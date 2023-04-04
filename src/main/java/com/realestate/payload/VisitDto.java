package com.realestate.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realestate.entity.ClientReg;
import lombok.Data;

import java.util.Date;
@Data
public class VisitDto {

    private long clientId;
    private long agentId;
    private  long propertyId;
    private Date visitDate;
    //@JsonIgnore
    private ClientReg clientReg;
}
