package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.ReviewDto;
import com.example.VadarodProject.entity.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto toDto(Review review);

    Review toEntity(ReviewDto dto);

    List<ReviewDto> toReviewDtoList(List<Review> reviews);

    List<Review> toReviewList(List<ReviewDto> Dtos);
}
