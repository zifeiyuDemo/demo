package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Invoice9021 {
    private Date time;

    private String corpSecret;

    private String personName;

    private String checkTime;

    private String cord;

    private String device;

    private Boolean mobile;

    private String agentName;

    public Invoice9021(Date time, String corpSecret, String personName, String checkTime, String cord, String device, Boolean mobile, String agentName) {
        this.time = time;
        this.corpSecret = corpSecret;
        this.personName = personName;
        this.checkTime = checkTime;
        this.cord = cord;
        this.device = device;
        this.mobile = mobile;
        this.agentName = agentName;
    }

    public static Invoice9021 ofRecord1(Date time, String personName, String checkTime, String cord){
        Invoice9021 record = new Invoice9021();
        of(time, personName, checkTime, cord, record);
        record.setCorpSecret("单位1");
        record.setDevice("001001");
        record.setMobile(false);
        record.setAgentName("代理1");
        return record;
    }

    public static Invoice9021 ofRecord2(Date time, String personName, String checkTime, String cord){
        Invoice9021 record = new Invoice9021();
        of(time, personName, checkTime, cord, record);
        record.setCorpSecret("单位2");
        record.setDevice("002002");
        record.setMobile(true);
        record.setAgentName("代理2");
        return record;
    }

    public static Invoice9021 ofRecord3(Date time, String personName, String checkTime, String cord){
        Invoice9021 record = new Invoice9021();
        of(time, personName, checkTime, cord, record);
        record.setCorpSecret("单位3");
        record.setDevice("003003");
        record.setMobile(true);
        record.setAgentName("代理3");
        return record;
    }

    private static Invoice9021 of(Date time, String personName, String checkTime, String cord, Invoice9021 record){
        record.setTime(time);
        record.setPersonName(personName);
        record.setCheckTime(checkTime);
        record.setCord(cord);
        return record;
    }



}