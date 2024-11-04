package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private short addressId;

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String addressName;

    // Constructors
    public Address() {
    }

    public Address(String addressName) {
        this.addressName = addressName;
    }

    // Getters and setters
    public short getAddressId() {
        return addressId;
    }

    public void setAddressId(short addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}
