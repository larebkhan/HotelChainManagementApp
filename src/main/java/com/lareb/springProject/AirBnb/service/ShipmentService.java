package com.lareb.springProject.AirBnb.service;

import org.springframework.stereotype.Service;


public interface ShipmentService {

    String orderPackage(Long orderId);

    String trackPackage(Long orderId);
}
