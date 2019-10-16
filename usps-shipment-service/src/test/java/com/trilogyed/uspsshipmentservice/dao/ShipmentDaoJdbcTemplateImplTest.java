package com.trilogyed.uspsshipmentservice.dao;

import com.trilogyed.uspsshipmentservice.model.Shipment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentDaoJdbcTemplateImplTest {
    @Autowired
    ShipmentDao dao;

    @Before
    public void setUp() throws Exception{
        List<Shipment> shipmentList = dao.getAllShipments();
        shipmentList.forEach(shipment -> {
            dao.deleteShipment(shipment.getId());
        });
    }

    @Test
    public void addGetDeleteShipment(){
        Shipment ship = new Shipment();
        ship.setTrackingNumber("ABCD123");
        ship.setRecipientName("John Doe");

        ship = dao.addShipment(ship);
        Shipment fromdao = dao.getShipmentByTrackingNumber(ship.getTrackingNumber());
        assertEquals(ship,fromdao);

        dao.deleteShipment(ship.getId());
        fromdao = dao.getShipmentByTrackingNumber(ship.getTrackingNumber());
        assertNull(fromdao);
    }

    @Test
    public void findConstraints() {
        try {
            Shipment ship = new Shipment();
            ship.setRecipientName("John Doe");
            ship = dao.addShipment(ship);
        } catch (Exception e) {

        }

        try {
            Shipment ship = new Shipment();
            ship.setTrackingNumber("ABCD123");
            ship = dao.addShipment(ship);
        } catch (Exception e) {

        }
    }
}
