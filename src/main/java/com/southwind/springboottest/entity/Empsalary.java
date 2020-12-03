package com.southwind.springboottest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
public class Empsalary {

    public Integer getEID() {
        return EID;
    }

    public void setEID(Integer EID) {
        this.EID = EID;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public Integer getEYEAR() {
        return EYEAR;
    }

    public void setEYEAR(Integer EYEAR) {
        this.EYEAR = EYEAR;
    }

    public Integer getEMONTH() {
        return EMONTH;
    }

    public void setEMONTH(Integer EMONTH) {
        this.EMONTH = EMONTH;
    }

    public Integer getELATE() {
        return ELATE;
    }

    public void setELATE(Integer ELATE) {
        this.ELATE = ELATE;
    }

    public Integer getEEARLY() {
        return EEARLY;
    }

    public void setEEARLY(Integer EEARLY) {
        this.EEARLY = EEARLY;
    }

    public Integer getEBONUS() {
        return EBONUS;
    }

    public void setEBONUS(Integer EBONUS) {
        this.EBONUS = EBONUS;
    }

    public Integer getEFUNALSALARY() {
        return EFINALYSALARY;
    }

    public void setEFUNALSALARY(Integer EFUNALSALARY) {
        this.EFINALYSALARY = EFUNALSALARY;
    }

    @Id
    private Integer EID;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ENAME;
    private Integer EYEAR;
    private Integer EMONTH;
    private Integer ELATE;
    private Integer EEARLY;
    private Integer EBONUS;
    private Integer EFINALYSALARY;
}
