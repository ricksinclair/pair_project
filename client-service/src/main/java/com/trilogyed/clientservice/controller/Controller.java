package com.trilogyed.clientservice.controller;

import com.trilogyed.clientservice.exception.NotFoundException;
import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.service.ServiceLayer;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Controller {
    @Autowired
    ServiceLayer sl;

    private ShipmentClient client;

    @CachePut(key = "#result.getId()")
    @PostMapping(value = "/clientfe/addshipment")
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment createShipment(@RequestBody @Valid Shipment shipment)
    {
        if(shipment.getTrackingNumber()==null || shipment.getRecipientName()==null) return null;
        else return sl.addShipment(shipment);
    }

    @Cacheable
    @GetMapping(value = "/clientfe/shipment/{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Shipment findShipmentByTrackingId(@PathVariable String trackingNumber)
    {
        Shipment ship = sl.getShipmentsByTrackingNumber(trackingNumber);
        if (ship==null) throw new NotFoundException("No shipment exists with this tracking Number.");
        return ship;
    }

}
