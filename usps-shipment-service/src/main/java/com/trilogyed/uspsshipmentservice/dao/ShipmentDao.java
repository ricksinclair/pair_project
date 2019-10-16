package com.trilogyed.uspsshipmentservice.dao;

import com.trilogyed.uspsshipmentservice.model.Shipment;

import java.util.List;

public interface ShipmentDao {
    Shipment getShipmentByTrackingNumber(String trackingNumber);
    Shipment addShipment(Shipment shipment);
    List<Shipment> getAllShipments();
    void deleteShipment(int id);
}
