package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Page<Review> findAll(Pageable pageable);
}
