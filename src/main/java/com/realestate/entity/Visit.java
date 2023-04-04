package com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="visits")
public class Visit {

    @Id
    @Column(name = "client_Id")
    private long clientId;
    private long agentId;
    private  long propertyId;
    private Date visitDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientReg clientReg;
}
