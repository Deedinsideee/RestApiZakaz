package com.example.restapizakaz.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * todo Document type OrderDTO
 */
@Getter
@Setter
public class OrderDTO {
    private int id;
    private String customerAddress;
    private String customerName;
    private Date dateOfCreation;
    private Long totalCost;
    private List<DetailsDTO> details;
}
