package com.shoparsenal.shoparsenal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventoryId", nullable = false)
    private Long inventoryId;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @Column(name = "quantity", nullable = false, unique = true)
    private Integer quantity;











/*
    public Order createOrder(OrderDTO orderDTO) {
       Optional<User> optionalUser = this.repository.findById(order.getUserId())
       if(optionalUser.isEmpty()){
            throw new Resourcesnotfound();
        }

       Optional<User> optionalUser = this.repository.findById(order.getUserId());
        if(optionalUser.isEmpty()){
            throw new Resourcesnotfound();
        }


       UserOrder  userOrder = new UserOrder();
       userOrder.setProduct(product.)
       userOrder.set(user)
       UserOrder order =  this.userOrderRepositiory.save(userOrder);

       if(order.getId == null){
            throw new
       }else{
           this.sendOrderNotification(optionalUser.get().getEmail, "Product Order", "Order successfully completed")
       }

    }

 */



}