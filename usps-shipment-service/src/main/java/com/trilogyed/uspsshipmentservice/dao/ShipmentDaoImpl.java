package com.trilogyed.uspsshipmentservice.dao;

import com.trilogyed.uspsshipmentservice.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShipmentDaoImpl implements ShipmentDao {

    private static final String SELECT_SHIPMENT=
            "select * from tracking where tracking_number=?";
    private static final String ADD_SHIPMENT=
            "insert into tracking (tracking_number,recipient_name) values (?,?)";
    private static final String GET_ALL=
            "select * from tracking";
    private static final String DELETE=
            "delete from tracking where id=?";
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ShipmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Shipment mapShipmentToRow(ResultSet rs, int rowNum) throws SQLException {
        Shipment shipment = new Shipment();
        shipment.setId(rs.getInt("id"));
        shipment.setTrackingNumber(rs.getString("tracking_number"));
        shipment.setRecipientName(rs.getString("recipient_name"));
        return shipment;
    }

    @Override
    public Shipment getShipmentByTrackingNumber(String trackingNumber) {
        try{
            return jdbcTemplate.queryForObject(SELECT_SHIPMENT,this::mapShipmentToRow,trackingNumber);
        }catch(EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    @Transactional
    public Shipment addShipment(Shipment shipment) {
        jdbcTemplate.update(ADD_SHIPMENT,
                shipment.getTrackingNumber(),
                shipment.getRecipientName());
        int id = jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        shipment.setId(id);
        return shipment;
    }

    @Override
    public List<Shipment> getAllShipments() {
        return jdbcTemplate.query(GET_ALL,this::mapShipmentToRow);
    }

    @Override
    public void deleteShipment(int id) {

        jdbcTemplate.update(DELETE,id);
    }
}
