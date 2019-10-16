package com.trilogyed.clientservice.util.feign;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentsUnitTest {

    @Autowired
    ShipmentClient shipmentClient;

    @Before
    private void setUp() throws Exception{

        shipmentClient.deleteAlLShipments();

    }
}
