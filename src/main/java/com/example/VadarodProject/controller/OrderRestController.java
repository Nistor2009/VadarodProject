package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.OrderDto;
import com.example.VadarodProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderRestController {
    private final OrderService orderService;

    @GetMapping("/find")
    public ResponseEntity<OrderDto> getOrderByParam(@RequestParam("id") Long id) {
        OrderDto orderDto = orderService.findById(id);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<OrderDto>> getAllOrder() {
        List<OrderDto> orderDto = orderService.findAll();
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @PostMapping("/delete")
    public OrderDto deleteOrder(@RequestBody OrderDto orderDto) {
        return orderService.deleteOrder(orderDto);
    }
}
