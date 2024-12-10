package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
public class DetailDepartment extends Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "EmulationPoint")
    private short emulationPoint;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId // This maps departmentId to the primary key of the Department
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
//    @JsonIgnore
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
//    @JsonIgnore
    private Address address;

    public DetailDepartment() {
    }

    public DetailDepartment(short emulationPoint, Department department, Address address) {
        this.emulationPoint = emulationPoint;
        this.department = department;
        this.address = address;
    }

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        this.emulationPoint = emulationPoint;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DetailDepartment{" +
                "emulationPoint=" + emulationPoint +
                ", department=" + department.getDepartmentName() +
                ", address=" + address.getAddressName() +
                '}';
    }
}
