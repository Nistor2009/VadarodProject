package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.ReviewDto;
import com.example.VadarodProject.service.ReviewService;
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
@RequestMapping("/review")
public class ReviewRestController {
    private final ReviewService reviewService;

    @GetMapping("/find")
    public ResponseEntity<ReviewDto> getReviewByParam(@RequestParam("id") Long id) {
        ReviewDto reviewDto = reviewService.findById(id);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ReviewDto>> getAllReview(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection;
        if (Objects.equals(direction, "asc")) {
            sortDirection = Sort.Direction.ASC;
        } else sortDirection = Sort.Direction.DESC;
        List<ReviewDto> reviewDto = reviewService.findAll(page, size, sort, sortDirection);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ReviewDto addReview(@RequestBody @Validated ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

    @PostMapping("/delete")
    public ReviewDto deleteReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.deleteReview(reviewDto);
    }
}
