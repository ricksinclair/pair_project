package com.trilogyed.uspsshipmentservice.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Shipment {
    private int id;
    @NotBlank(message = "Tracking number must be entered.")
    @Size(max=25)
    private String trackingNumber;
    @NotBlank(message = "Must enter recipient name")
    @Size(max=80)
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
        Shipment shipments = (Shipment) o;
        return id == shipments.id &&
                Objects.equals(trackingNumber, shipments.trackingNumber) &&
                Objects.equals(recipientName, shipments.recipientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackingNumber, recipientName);
    }
}
