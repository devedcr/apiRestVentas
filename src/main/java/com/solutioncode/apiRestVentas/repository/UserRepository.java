package com.solutioncode.apiRestVentas.repository;

import com.solutioncode.apiRestVentas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select u.* from usuario u where email=:email limit 1", nativeQuery = true)
    public Optional<User> findByEmail(@Param("email") String email);
}
