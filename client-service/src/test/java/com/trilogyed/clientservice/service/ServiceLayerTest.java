package com.trilogyed.clientservice.service;

import com.trilogyed.clientservice.model.Shipment;
import com.trilogyed.clientservice.util.feign.ShipmentClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer sl;
    ShipmentClient client;

    @Test
    public void addGetShipment(){
        client=mock(ShipmentClient.class);

        Shipment ship = new Shipment();
        ship.setTrackingNumber("ABCD123");
        ship.setRecipientName("John Doe");

        Shipment ship1 = new Shipment();
        ship1.setId(1);
        ship1.setTrackingNumber("ABCD123");
        ship1.setRecipientName("John Doe");

        doReturn(ship1).when(client).createShipments(ship);
        doReturn(ship1).when(client).getShipmentByTrackingNumber("ABCD123");

        sl = new ServiceLayer(client);
        Shipment shipment = sl.addShipment(ship);
        Shipment afterAddingShipment = sl.getShipmentsByTrackingNumber("ABCD123");
        assertEquals(shipment,afterAddingShipment);
    }




}
