package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short addressId;

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String addressName;

    @OneToMany(mappedBy = "address")
    @JsonManagedReference
    private List<DetailDepartment> detailDepartments;

    public Address() {
    }

    public Address(short addressId, String addressName) {
        this.addressId = addressId;
        this.addressName = addressName;
    }

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

    public List<DetailDepartment> getDetailDepartments() {
        return detailDepartments;
    }

    public void setDetailDepartments(List<DetailDepartment> detailDepartments) {
        this.detailDepartments = detailDepartments;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}
