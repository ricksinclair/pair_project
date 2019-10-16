package com.trilogyed.uspsshipmentservice.mocks;

import com.trilogyed.uspsshipmentservice.dao.ShipmentDao;
import com.trilogyed.uspsshipmentservice.model.Shipment;
import com.trilogyed.uspsshipmentservice.servicelayer.ServiceLayer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerMocks {
    ServiceLayer sl;
    ShipmentDao dao;
    @Test
    public void addGetShipment(){
        dao=mock(ShipmentDao.class);

        Shipment ship = new Shipment();
        ship.setTrackingNumber("ABCD123");
        ship.setRecipientName("John Doe");

        Shipment ship1 = new Shipment();
        ship1.setId(1);
        ship1.setTrackingNumber("ABCD123");
        ship1.setRecipientName("John Doe");

        doReturn(ship1).when(dao).addShipment(ship);
        doReturn(ship1).when(dao).getShipmentByTrackingNumber("ABCD123");

        sl = new ServiceLayer(dao);
        Shipment shipment = sl.addShipment(ship);
        Shipment afterAddingShipment = sl.getByTrackingId("ABCD123");
        assertEquals(shipment,afterAddingShipment);
    }


}
