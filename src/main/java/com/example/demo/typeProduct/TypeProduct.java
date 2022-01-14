package com.example.demo.typeProduct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_TypeProduct;
    private String name;
}
