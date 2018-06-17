package com.example.project.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "carts")
public class Cart implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "cart_name")
    private String cart_name;

    public String getCart_name() {
        return cart_name;
    }

    public void setCart_name(String cart_name) {
        this.cart_name = cart_name;
    }

    public String getCartName() {
        return cart_name;
    }

    public void setCartName(String cart_name) {
        this.cart_name = cart_name;
    }

    @Column(name = "capacity")
    private Integer capacity;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Cart(Long id, String cart_name, Integer capacity){ //}, List<Item> itemsList){
        this.id = id;
        this.cart_name = cart_name;
        this.capacity = capacity;
//        this.itemsList = itemsList;
    }

    public Cart(){}

    @Override
    public String toString() {
        return getId() + " - " + getCartName();
    }

    @ManyToMany( fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST }  )
    @JoinTable(
            name = "itemtocart",
            joinColumns = {
                    @JoinColumn(name = "cartid", referencedColumnName = "id",
                            nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "itemid", referencedColumnName = "id",
                            nullable = false, updatable = false)
            }
    )
    public List<Item> itemsList = new LinkedList<>();

    @Override
    public boolean equals(Object anObject) {
        if (!(anObject instanceof Cart)) {
            return false;
        }
        return (this.id == ((Cart)anObject).id);
    }

    @Override
    public int hashCode(){
        return Math.toIntExact(id);
    }
}
