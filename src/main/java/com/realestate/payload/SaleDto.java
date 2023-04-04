package com.realestate.payload;

import com.realestate.entity.ClientReg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto {
    private Long clientId;
    private Long agentId;
    private Long propertyId;
    private Date saleDate;

    private ClientReg clientReg;
}
