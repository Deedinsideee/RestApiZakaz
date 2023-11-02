package com.example.restapizakaz.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DETAILS")
@IdClass(DetailsId.class)
@Getter
@Setter
public class Details {
    @Column(name = "id", nullable = false)
    Long id;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;
    @Id
    @Column(name = "serial_number", nullable = false)
    private String serialNumber;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "amount", nullable = false)
    private int amount;

}

