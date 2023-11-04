package com.example.restapizakaz.repository;

import com.example.restapizakaz.Model.Details;
import com.example.restapizakaz.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * todo Document type DetailsRepository
 */
@Repository

public interface DetailsRepository extends JpaRepository<Details,Long> {
    public List<Details> findDetailsByOrder_id(int order_id);

    public Details findDetailsByOrder_idAndId(int order_id,Long id);

}
