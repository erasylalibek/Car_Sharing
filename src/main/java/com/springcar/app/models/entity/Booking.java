package com.springcar.app.models.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import javax.persistence.*;

@Entity
@Data
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long client_id;
    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false, updatable = false)
    @Getter(AccessLevel.NONE)
    private Client client;

    private Long car_id;
    @ManyToOne
    @JoinColumn(name = "car_id",insertable = false, updatable = false)
    @Getter(AccessLevel.NONE)
    private Car car;


    private String office;
    private String date;
    private String number;
}
