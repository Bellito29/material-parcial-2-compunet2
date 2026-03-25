package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "drone_events")
@NoArgsConstructor
public class DroneEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_time")
    private Timestamp eventTime;

    private String description;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
