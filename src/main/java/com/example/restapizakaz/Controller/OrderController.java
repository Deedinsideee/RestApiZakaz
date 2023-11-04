package com.example.restapizakaz.Controller;

import com.example.restapizakaz.DTO.OrderDTO;
import com.example.restapizakaz.Model.Details;
import com.example.restapizakaz.Model.Order;
import com.example.restapizakaz.Service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * todo Document type OrderController
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @Operation(description = "Получить все заказы", method = "getAll")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDTO>> getAll ()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());

    }

    @Operation(description = "Изменить заказ", method = "changeOne")
    @RequestMapping(value = "/changeOne", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> changeOne (@RequestBody String json)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            OrderDTO orderDTO = objectMapper.readValue(json, OrderDTO.class);
            orderService.update(orderDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(new Order());

    }
}
