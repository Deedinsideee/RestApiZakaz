package com.example.restapizakaz.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 * todo Document type DetailsDTO
 */
@Getter
@Setter
public class DetailsDTO{
    private Long id;
    private String serialNumber;
    private String productName;
    private int amount;
}
