package com.example.restapizakaz.Service;

import com.example.restapizakaz.DTO.DetailsDTO;
import com.example.restapizakaz.DTO.OrderDTO;
import com.example.restapizakaz.Model.Details;
import com.example.restapizakaz.Model.Order;
import com.example.restapizakaz.repository.DetailsRepository;
import com.example.restapizakaz.repository.OrderRepostitory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * todo Document type OrderService
 */
@Service
public class OrderService {

    private final OrderRepostitory orderRepostitory;
    private final DetailsRepository detailsRepository;

    public OrderService(OrderRepostitory orderRepostitory, DetailsRepository detailsRepository) {
        this.orderRepostitory = orderRepostitory;
        this.detailsRepository = detailsRepository;
    }

    public List<OrderDTO> getAllOrders()
    {
        List<OrderDTO> orders =maptoOrderDTO( orderRepostitory.findAll());
        for (OrderDTO order : orders) {
            List<DetailsDTO> details = maptoDetailDto(detailsRepository.findDetailsByOrder_id(order.getId()));
            details.sort(Comparator.comparingLong(DetailsDTO::getId));
            order.setDetails(details);

        }
        orders.sort(Comparator.comparingInt(OrderDTO::getId));
        return orders;
    }

    private List<OrderDTO> maptoOrderDTO(List<Order> orders) {
        return orders.stream()
            .map(order -> {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setCustomerAddress(order.getCustomerAddress());
                orderDTO.setCustomerName(order.getCustomerName());
                orderDTO.setDateOfCreation(order.getDateOfCreation());
                orderDTO.setTotalCost(order.getTotalCost());
                return orderDTO;
            })
            .collect(Collectors.toList());
    }
    private List<DetailsDTO> maptoDetailDto(List<Details> details) {
        return details.stream()
            .map(detail -> {
                DetailsDTO detailsDTO = new DetailsDTO();
                detailsDTO.setId(detail.getId());
                detailsDTO.setSerialNumber(detail.getSerialNumber());
                detailsDTO.setProductName(detail.getProductName());
                detailsDTO.setAmount(detail.getAmount());

                return detailsDTO;
            })
            .collect(Collectors.toList());
    }
    public void update(OrderDTO orderDto)
    {
       maptoOrder(orderDto);
    }
    private void maptoOrder(OrderDTO orderDto) {
        Optional<Order> orders = orderRepostitory.findById(Long.valueOf(orderDto.getId()));
        if (orders.isPresent()) {
            Order order = orders.get();
            order.setCustomerName(orderDto.getCustomerName());
            order.setCustomerAddress(orderDto.getCustomerAddress());
            order.setDateOfCreation(orderDto.getDateOfCreation());
            order.setTotalCost(orderDto.getTotalCost());
            maptoDetails(orderDto.getDetails(), order);
            orderRepostitory.save(order);
        }
    }

    private void maptoDetails(List<DetailsDTO> details,Order order) {
        details.forEach(s->
        {
            Details detail = detailsRepository.findDetailsByOrder_idAndId(order.getId(),s.getId());
            detail.setOrder(order);
            detail.setId(s.getId());
            detail.setSerialNumber(s.getSerialNumber());
            detail.setProductName(s.getProductName());
            detail.setAmount(s.getAmount());
            detailsRepository.save(detail);



        }
        );
    }

}
