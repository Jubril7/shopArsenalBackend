package com.shoparsenal.shoparsenal.repo;

import com.shoparsenal.shoparsenal.model.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<LocalUser, Long> {
    Optional<LocalUser> findByEmailIgnoreCase(String email);
    Optional<LocalUser> findByUsernameIgnoreCase(String username);

//    Optional<LocalUser> findByUsernameAndEmail(String username, String email);

}
