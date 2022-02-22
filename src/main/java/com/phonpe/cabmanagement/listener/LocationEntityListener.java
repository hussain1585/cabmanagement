package com.phonpe.cabmanagement.listener;

import com.phonpe.cabmanagement.domain.Location;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class LocationEntityListener
{
    @PrePersist
    public void prePersist(Location location)
    {
        log.info("prePersist : entity booking with id=>{} will be persisted to DB with body", location.getLocationId(), location);
    }

    @PostPersist
    public void postPersist(Location location)
    {
        log.info("postPersist : entity booking with id=>{} is persisted to DB with body", location.getLocationId(), location);
    }

    @PreUpdate
    public void preUpdate(Location location)
    {
        log.info("preUpdate : entity booking with id=>{} will be updated to DB with body", location.getLocationId(), location);
    }

    @PostUpdate
    public void postUpdate(Location location)
    {
        log.info("postUpdate : entity booking with id=>{} is updated to DB with body", location.getLocationId(), location);
    }

    @PreRemove
    public void preRemove(Location location)
    {
        log.info("preRemove : entity booking with id=>{} will be removed from DB with body", location.getLocationId(), location);
    }

    @PostRemove
    public void postRemove(Location location)
    {
        log.info("postRemove : entity booking with id=>{} is removed to DB with body", location.getLocationId(), location);
    }
}
