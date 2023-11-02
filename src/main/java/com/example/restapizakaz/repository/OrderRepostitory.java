package com.example.restapizakaz.repository;

import com.example.restapizakaz.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * todo Document type OrderRepostitory
 */
@Repository

public interface OrderRepostitory extends JpaRepository<Order,Long> {


}
