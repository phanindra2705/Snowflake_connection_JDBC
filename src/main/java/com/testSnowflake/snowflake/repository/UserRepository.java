package com.testSnowflake.snowflake.repository;

import com.testSnowflake.snowflake.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
