package com.springvueoauth2.server.repository;

import com.springvueoauth2.server.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByLoginId(String loginId);


}
