package com.example.restapizakaz.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_generator")
    @SequenceGenerator(name = "order_id_generator", sequenceName = "sq_order_id", allocationSize = 1)
    private int id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_adress", nullable = false)
    private String customerAddress;

    @Column(name = "total_cost", nullable = false)
    private Long totalCost;

    @Column(name = "date_of_creation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Details> details;

    // Геттеры и сеттеры
}

