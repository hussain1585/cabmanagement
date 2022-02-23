package com.phonpe.cabmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    private String houseOwnerSalutation;
    private String houseOwner;
    private String houseNo;
    private String floorNo;
    private String pinCode;

    @ManyToOne
    @JoinColumn(name = "address_service_city_fk")
    private ServiceCity serviceCity;
}
