package com.southwind.springboottest.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class USERKS {


    public Integer getKID() {
        return KID;
    }

    public void setKID(Integer KID) {
        this.KID = KID;
    }

    public String getKNAME() {
        return KNAME;
    }

    public void setKNAME(String KNAME) {
        this.KNAME = KNAME;
    }

    public String getKPASSWORD() {
        return KPASSWORD;
    }

    public void setKPASSWORD(String KPASSWORD) {
        this.KPASSWORD = KPASSWORD;
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer KID;
    private String KNAME;
    private String KPASSWORD;
}
