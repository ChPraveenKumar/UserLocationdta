package com.userlocation;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Serializable> {

	User findById(int id);
}
