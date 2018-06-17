package com.example.project.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.example.project.model.Cart;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Data
@Entity
@Table(name = "items")
public class Item extends AbstractPersistable<Long> {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    public Long id;

    @Column(name = "item_name")
    private String item_name;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Item(String item_name, String description, Integer price){
        this.item_name = item_name;
        this.description = description;
        this.price = price;
        //this.carts = new ArrayList<Cart>();
    }

    public Item(){}

//    @Override
//    public String toString() {
////        return getId().toString();
//        return getId() + " - " + getItem_name();
//    }


    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "itemsList", cascade = CascadeType.PERSIST  )
    private List<Cart> carts;

//    public List<Cart> getCarts() {
//        return carts;
//    }
//
//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }

//    @Override
//    public boolean equals(Object anObject) {
//        if (!(anObject instanceof Item)) {
//            return false;
//        }
//        return (this.id.equals(((Item)anObject).id));
//    }
//
//    @Override
//    public int hashCode(){
//        return Math.toIntExact(id);
//    }
}
