package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.ReviewDto;
import com.example.VadarodProject.entity.Review;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-30T21:35:24+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewDto toDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId( review.getId() );
        reviewDto.setClientName( review.getClientName() );
        reviewDto.setDescription( review.getDescription() );
        reviewDto.setMark( review.getMark() );

        return reviewDto;
    }

    @Override
    public Review toEntity(ReviewDto dto) {
        if ( dto == null ) {
            return null;
        }

        Review review = new Review();

        review.setId( dto.getId() );
        review.setClientName( dto.getClientName() );
        review.setDescription( dto.getDescription() );
        review.setMark( dto.getMark() );

        return review;
    }

    @Override
    public List<ReviewDto> toReviewDtoList(List<Review> reviews) {
        if ( reviews == null ) {
            return null;
        }

        List<ReviewDto> list = new ArrayList<ReviewDto>( reviews.size() );
        for ( Review review : reviews ) {
            list.add( toDto( review ) );
        }

        return list;
    }

    @Override
    public List<Review> toReviewList(List<ReviewDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<Review> list = new ArrayList<Review>( Dtos.size() );
        for ( ReviewDto reviewDto : Dtos ) {
            list.add( toEntity( reviewDto ) );
        }

        return list;
    }
}
