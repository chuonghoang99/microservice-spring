package com.chuonghoang.service01.repo;

import jakarta.transaction.Transactional;
import com.chuonghoang.service01.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("update User u set u.password =?2 where u.email = ?1")
    void updatePassword(String email, String pass);
}
