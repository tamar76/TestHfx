package com.test.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private Double price;

   public Product(long id, String name, double price) {
      this.id = id;
      this.name = name;
      this.price = price;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getId() {
      return id;
   }

   public void setContactValue(String name) {
      this.name = name;
   }

   public String getContactValue() {
      return name;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public Double getPrice() {
      return price;
   }

}
