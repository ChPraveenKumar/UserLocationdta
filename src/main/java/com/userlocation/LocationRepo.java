package com.userlocation;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public interface LocationRepo extends JpaRepository<Location, Serializable> {
	
	Location findById(int id);
}
