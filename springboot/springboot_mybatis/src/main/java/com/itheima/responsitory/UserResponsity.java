package com.itheima.responsitory;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserResponsity extends JpaRepository<User,Long> {
   public List<User> findAll();
}
