package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.Shipments;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    final ShipmentClient shipmentClient;


    public ServiceLayer(ShipmentClient shipmentClient) {
        this.shipmentClient = shipmentClient;
    }

    public Shipment addShipment(Shipments shipment){

    }
}
