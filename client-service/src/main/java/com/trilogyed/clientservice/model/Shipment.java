package com.trilogyed.clientservice.model;

import java.util.Objects;

public class Shipment {

    private int id;
    private String trackingNumber;
    private String recipientName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return getId() == shipment.getId() &&
                getTrackingNumber().equals(shipment.getTrackingNumber()) &&
                getRecipientName().equals(shipment.getRecipientName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTrackingNumber(), getRecipientName());
    }

    @Override
    public String toString() {
        return "Shipments{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", recipientName='" + recipientName + '\'' +
                '}';
    }
}
