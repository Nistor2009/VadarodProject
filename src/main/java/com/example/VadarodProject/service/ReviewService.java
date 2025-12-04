package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.ReviewDto;
import com.example.VadarodProject.entity.Review;
import com.example.VadarodProject.mapper.ReviewMapper;
import com.example.VadarodProject.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewDto addReview(ReviewDto review) {
        return reviewMapper.toDto(reviewRepository.save(reviewMapper.toEntity(review)));
    }

    public ReviewDto deleteReview(ReviewDto review) {
        reviewRepository.delete(reviewMapper.toEntity(review));
        return review;
    }

    public ReviewDto findById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return reviewMapper.toDto(review.orElse(new Review()));
    }

    public List<ReviewDto> findAll(int page,
                                   int size,
                                   String sort,
                                   Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        Page<Review> pageClient = reviewRepository.findAll(pageable);
        return reviewMapper.toReviewDtoList(pageClient.get().toList());
    }
}
