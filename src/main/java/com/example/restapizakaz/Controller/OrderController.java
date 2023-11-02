package com.example.restapizakaz.Controller;

import com.example.restapizakaz.DTO.OrderDTO;
import com.example.restapizakaz.Model.Details;
import com.example.restapizakaz.Model.Order;
import com.example.restapizakaz.Service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * todo Document type OrderController
 */
@RestController
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
}
