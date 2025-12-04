package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.OrderDto;
import com.example.VadarodProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<List<OrderDto>> getAllOrder(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection;
        if (Objects.equals(direction, "asc")) {
            sortDirection = Sort.Direction.ASC;
        } else sortDirection = Sort.Direction.DESC;
        List<OrderDto> orderDto = orderService.findAll(page, size, sort, sortDirection);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public OrderDto addOrder(@RequestBody @Validated OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @PostMapping("/delete")
    public OrderDto deleteOrder(@RequestBody OrderDto orderDto) {
        return orderService.deleteOrder(orderDto);
    }
}
