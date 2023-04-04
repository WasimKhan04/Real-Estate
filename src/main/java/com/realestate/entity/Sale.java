package com.realestate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @Column(name="client_Id")
    private Long clientId;

    private Long agentId;

    private Long propertyId;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date saleDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private ClientReg clientReg;
}
