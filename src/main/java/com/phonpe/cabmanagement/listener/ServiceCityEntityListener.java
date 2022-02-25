package com.phonpe.cabmanagement.listener;

import com.phonpe.cabmanagement.domain.ServiceCity;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class ServiceCityEntityListener
{
    @PrePersist
    public void prePersist(ServiceCity serviceCity)
    {
        log.debug("prePersist : entity ServiceCities with id=>{} will be persisted to DB with body", serviceCity.getServiceCityId(), serviceCity);
    }

    @PostPersist
    public void postPersist(ServiceCity serviceCity)
    {
        log.debug("postPersist : entity ServiceCities with id=>{} is persisted to DB with body", serviceCity.getServiceCityId(), serviceCity);
    }

    @PreUpdate
    public void preUpdate(ServiceCity serviceCity)
    {
        log.debug("preUpdate : entity ServiceCities with id=>{} will be updated to DB with body", serviceCity.getServiceCityId(), serviceCity);
    }

    @PostUpdate
    public void postUpdate(ServiceCity serviceCity)
    {
        log.debug("postUpdate : entity ServiceCities with id=>{} is updated to DB with body", serviceCity.getServiceCityId(), serviceCity);
    }

    @PreRemove
    public void preRemove(ServiceCity serviceCity)
    {
        log.debug("preRemove : entity ServiceCities with id=>{} will be removed from DB with body", serviceCity.getServiceCityId(), serviceCity);
    }

    @PostRemove
    public void postRemove(ServiceCity serviceCity)
    {
        log.debug("postRemove : entity ServiceCities with id=>{} is removed to DB with body", serviceCity.getServiceCityId(), serviceCity);
    }
}
