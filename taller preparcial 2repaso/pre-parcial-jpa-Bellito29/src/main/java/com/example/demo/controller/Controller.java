package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Delivery;
import com.example.demo.model.DronePosition;
import com.example.demo.repository.IDeliveryRepository;
import com.example.demo.repository.IDronePositionRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/controller")
@RequiredArgsConstructor
public class Controller {

    private final IDeliveryRepository deliveryRepository;
    private final IDronePositionRepository dronePositionRepository;
    
    @GetMapping("/{code}/completed")
    public List<Delivery> getCompletedDeliveriesByDrone(@PathVariable String code) {
        return deliveryRepository.findAllByDrone_CodeAndStatus(code, "COMPLETED");
    }
        @GetMapping("/drones/{code}/positions")
    public List<DronePosition> getDroneRouteByCode(@PathVariable String code) {
        return dronePositionRepository.findAllByDrone_CodeOrderByRecordedAtAsc(code);
    }
}