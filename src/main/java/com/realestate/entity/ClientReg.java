package com.realestate.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String clientName;
    private String clientAddress;
    private String phoneNum;
    private String email;
    private String gender;
    private String username;
    private String password;
    @JsonIgnore
    @OneToOne(mappedBy = "clientReg")
    private Sale sale;
    @JsonIgnore
    @OneToOne(mappedBy = "clientReg",cascade = CascadeType.ALL)
    private Visit visit;

}
