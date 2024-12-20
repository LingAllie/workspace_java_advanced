package com.vti.entity;

public class DepartmentDTO {

    private short id;
    private String name;
    private String address;

    public DepartmentDTO() {
    }

    public DepartmentDTO(short id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
