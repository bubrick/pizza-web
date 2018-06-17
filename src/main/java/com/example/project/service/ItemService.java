package com.example.project.service;

import com.example.project.model.Item;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ItemService extends Repository<Item, Long> {
    Item findById(Long id);

    List<Item> selectAll();

    void save(Item item);

    void update(Item item);

    void deleteById(Long id);
}
