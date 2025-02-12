package com.growup.demo.user.dao;

import com.growup.demo.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdx(Long idx);

    boolean existsByEmail(String email);


}
