package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.ReviewDto;
import com.example.VadarodProject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<ReviewDto>> getAllReview() {
        List<ReviewDto> reviewDto = reviewService.findAll();
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ReviewDto addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

    @PostMapping("/delete")
    public ReviewDto deleteReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.deleteReview(reviewDto);
    }
}
