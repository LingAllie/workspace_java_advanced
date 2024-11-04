package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Position`")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short positionId;

    @Column(name = "PositionName", nullable = false, unique = true)
    @Convert(converter = PositionNameConverter.class)
    private PositionName positionName;

    public Position() {
    }

    public Position(short positionId, PositionName positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public short getPositionId() {
        return positionId;
    }

    public void setPositionId(short positionId) {
        this.positionId = positionId;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                '}';
    }

    public enum PositionName {
        DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");

        private String name;

        private PositionName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static PositionName toEnum(String sqlName) {
            for (PositionName p : PositionName.values()) {
                if (p.getName().equals(sqlName)) {
                    return p;
                }
            }
            return null;
        }
    }
}
