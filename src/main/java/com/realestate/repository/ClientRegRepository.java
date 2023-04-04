package com.realestate.repository;

import com.realestate.entity.ClientReg;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRegRepository extends JpaRepository<ClientReg, Long> {
}
