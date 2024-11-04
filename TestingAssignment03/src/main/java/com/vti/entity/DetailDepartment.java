package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DetailDepartment")
public class DetailDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @MapsId("departmentId")
    private short departmentId;

    @OneToOne
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    private Department department;

    @OneToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    @Column(name = "EmulationPoint")
    private short emulationPoint;

    // Constructors
    public DetailDepartment() {
    }

    public DetailDepartment(Department department, Address address, short emulationPoint) {
        this.department = department;
        this.address = address;
        this.emulationPoint = emulationPoint;
    }

    // Getters and setters

    public short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(short departmentId) {
        this.departmentId = departmentId;
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

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        this.emulationPoint = emulationPoint;
    }

    @Override
    public String toString() {
        return "DetailDepartment{" +
                "departmentId=" + departmentId +
                ", department=" + department +
                ", address=" + address +
                ", emulationPoint=" + emulationPoint +
                '}';
    }
}
