package com.realestate.repository;

import com.realestate.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SaleRepository extends JpaRepository<Sale, Long> {
}
