package com.phonpe.cabmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address
{
    @Id
    @Column(name = "addressId", nullable = false)
    private long addressId;
    private String houseOwnerSalutation;
    private String houseOwner;
    private String houseNo;
    private String floorNo;
    private String pinCode;
    private String city;
    private String state;
    private String country;
}
