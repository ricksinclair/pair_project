package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    final ShipmentClient shipmentClient;

    @Autowired
    public ServiceLayer(ShipmentClient shipmentClient) {
        this.shipmentClient = shipmentClient;
    }

    public Shipment addShipment(Shipment shipment){
        return shipmentClient.createShipments(shipment);
    }

    public Shipment getShipmentsByTrackingNumber(String trackingNumber){
        return shipmentClient.getShipmentByTrackingNumber(trackingNumber);
    }


}
