package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Cure;
import com.example.VadarodProject.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CureRepository extends CrudRepository<Cure, Long> {
    List<Cure> findCureByName(String name);

    List<Cure> findCureByIsNeedRecipe(boolean recipe);

    @Query(value = "select c from Cure c where c.name =:name")
    List<Cure> findByQuery(@Param("name") String name);

    Page<Cure> findAll(Pageable pageable);

}
