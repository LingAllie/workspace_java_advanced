package com.vti.entity;

import com.vti.entity.converter.PositionNameConverter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY) // One salary to many accounts
    private List<Account> accounts;

    public Position() {
    }

    public Position(PositionName positionName) {
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName=" + positionName +
                '}';
    }

    public enum PositionName {
        DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");

        private String value;

        private PositionName(String value) {
            this.value = value;
        }
        public String getName() {
            return value;
        }

        public static PositionName toEnum(String sqlValue) {
            for (PositionName p : PositionName.values()) {
                if (p.getName().equals(sqlValue)) {
                    return p;
                }
            }
            return null;
        }
    }
}
