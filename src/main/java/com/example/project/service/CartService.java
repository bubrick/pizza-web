package com.example.project.service;

import com.example.project.model.*;
import java.util.List;


public interface  CartService {
    Cart findById(Long id);

    List<Cart> selectAll();

    void save(Cart cart);

    void update(Cart cart);

    void deleteById(Long id);

    List<Item> selectItemsByCartId(Long id);

    void deleteItemById(Long id, Long id2);
}
