package com.boot.boot_springdata.repository;

import com.boot.boot_springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Brian in 21:17 2018/12/2
 */
public interface UserRepository extends JpaRepository<User, Integer>{
}
