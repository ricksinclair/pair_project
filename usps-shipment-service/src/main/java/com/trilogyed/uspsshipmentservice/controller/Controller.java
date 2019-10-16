package com.trilogyed.uspsshipmentservice.controller;

import com.trilogyed.uspsshipmentservice.dao.ShipmentDao;
import com.trilogyed.uspsshipmentservice.exception.NotFoundException;
import com.trilogyed.uspsshipmentservice.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"shipmentController"})
public class Controller {

    @Autowired
    ShipmentDao dao;

    @CachePut(key = "#result.getId()")
    @PostMapping(value = "/shipment/addshipment")
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment createShipment(@RequestBody @Valid Shipment shipment)
    {
        if(shipment.getTrackingNumber()==null || shipment.getRecipientName()==null) return null;
        else return dao.addShipment(shipment);
    }

    @Cacheable
    @GetMapping(value = "/shipment/{trackingNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Shipment findShipmentByTrackingId(@PathVariable String trackingNumber)
    {
        Shipment ship = dao.getShipmentByTrackingNumber(trackingNumber);
        if (ship==null) throw new NotFoundException("No shipment exists with this tracking Number.");
        return ship;
    }




}
