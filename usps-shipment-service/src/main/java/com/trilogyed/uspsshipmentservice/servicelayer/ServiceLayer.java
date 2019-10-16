package com.trilogyed.uspsshipmentservice.servicelayer;

import com.trilogyed.uspsshipmentservice.dao.ShipmentDao;
import com.trilogyed.uspsshipmentservice.exception.NotFoundException;
import com.trilogyed.uspsshipmentservice.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    ShipmentDao dao;
    @Autowired
    public ServiceLayer(ShipmentDao dao) {
        this.dao = dao;
    }

    public Shipment addShipment(Shipment shipment){
        if(shipment.getTrackingNumber()==null || shipment.getRecipientName()==null) return null;
        else return dao.addShipment(shipment);
    }

    public Shipment getByTrackingId(String trackingId){
        Shipment ship = dao.getShipmentByTrackingNumber(trackingId);
        if (ship==null) throw new NotFoundException("No shipment exists with this tracking Number.");
        return dao.getShipmentByTrackingNumber(trackingId);
    }





}
