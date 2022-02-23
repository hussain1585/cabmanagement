package com.phonpe.cabmanagement.listener;

import com.phonpe.cabmanagement.domain.ServiceCities;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class ServiceCityEntityListener
{
    @PrePersist
    public void prePersist(ServiceCities serviceCities)
    {
        log.info("prePersist : entity ServiceCities with id=>{} will be persisted to DB with body", serviceCities.getServiceCityId(), serviceCities);
    }

    @PostPersist
    public void postPersist(ServiceCities serviceCities)
    {
        log.info("postPersist : entity ServiceCities with id=>{} is persisted to DB with body", serviceCities.getServiceCityId(), serviceCities);
    }

    @PreUpdate
    public void preUpdate(ServiceCities serviceCities)
    {
        log.info("preUpdate : entity ServiceCities with id=>{} will be updated to DB with body", serviceCities.getServiceCityId(), serviceCities);
    }

    @PostUpdate
    public void postUpdate(ServiceCities serviceCities)
    {
        log.info("postUpdate : entity ServiceCities with id=>{} is updated to DB with body", serviceCities.getServiceCityId(), serviceCities);
    }

    @PreRemove
    public void preRemove(ServiceCities serviceCities)
    {
        log.info("preRemove : entity ServiceCities with id=>{} will be removed from DB with body", serviceCities.getServiceCityId(), serviceCities);
    }

    @PostRemove
    public void postRemove(ServiceCities serviceCities)
    {
        log.info("postRemove : entity ServiceCities with id=>{} is removed to DB with body", serviceCities.getServiceCityId(), serviceCities);
    }
}
