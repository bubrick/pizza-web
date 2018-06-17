package com.example.project.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemDTO {
    @NotNull
    @NotEmpty
    private String item_name;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    @NotEmpty
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
