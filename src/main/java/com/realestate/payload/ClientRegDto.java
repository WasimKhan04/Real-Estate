package com.realestate.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realestate.entity.Sale;
import com.realestate.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRegDto {
    private Long clientId;

    private String clientName;

    private String clientAddress;

    private String phoneNum;

    private String email;

    private String gender;

    private String username;

    private String password;

    @JsonIgnore
    private Sale sale;
    @JsonIgnore
    private Visit visit;
}
