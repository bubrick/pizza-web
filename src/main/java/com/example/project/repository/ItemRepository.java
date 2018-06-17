package com.example.project.repository;

import com.example.project.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long>{
    Optional<Item> findById(Long id);

}
