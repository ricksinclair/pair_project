package com.trilogyed.clientservice.util.feign;


import com.trilogyed.clientservice.model.Shipments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = "shipment-service")
public interface ShipmentClient {

    @RequestMapping(value = "/shipment/{trackingNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    Shipments getShipmentByTrackingNumber(@PathVariable String trackingNumber);


    @RequestMapping(value = "/shipment/addshipment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Shipments createShipments(@RequestBody @Valid Shipments shipment);

    @RequestMapping(value = "/shipment", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAlLShipments();
}


