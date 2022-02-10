package com.example.demo.tchat;

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
public class Tchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tchat;
    private Integer id_userone;
    private Integer id_usertwo;
    private Integer id_advert;
}
