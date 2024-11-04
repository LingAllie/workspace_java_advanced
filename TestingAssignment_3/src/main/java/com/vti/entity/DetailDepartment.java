package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DetailDepartment")
public class DetailDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "DepartmentID")
    private short departmentId;

    @Column(name = "EmulationPoint")
    private short emulationPoint;

    @OneToOne
    @MapsId // This maps departmentId to the primary key of the Department
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    public DetailDepartment() {
    }

    public DetailDepartment(short emulationPoint, Department department, Address address) {
        this.departmentId = department.getDepartmentId();
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

    public short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(short departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "DetailDepartment{" +
                "emulationPoint=" + emulationPoint +
                ", department=" + department +
                ", address=" + address +
                '}';
    }
}
