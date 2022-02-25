package com.phonpe.cabmanagement.listener;

import com.phonpe.cabmanagement.domain.Rider;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class RiderEntityListener
{
    @PrePersist
    public void prePersist(Rider rider)
    {
        log.debug("prePersist : entity Rider with id=>{} will be persisted to DB with body => {}", rider.getRiderId(), rider);
    }

    @PostPersist
    public void postPersist(Rider rider)
    {
        log.debug("postPersist : entity Rider with id=>{} is persisted to DB with body => {}", rider.getRiderId(), rider);
    }

    @PreUpdate
    public void preUpdate(Rider rider)
    {
        log.debug("preUpdate : entity Rider with id=>{} will be updated to DB with body => {}", rider.getRiderId(), rider);
    }

    @PostUpdate
    public void postUpdate(Rider rider)
    {
        log.debug("postUpdate : entity Rider with id=>{} is updated to DB with body => {}", rider.getRiderId(), rider);
    }

    @PreRemove
    public void preRemove(Rider rider)
    {
        log.debug("preRemove : entity Rider with id=>{} will be removed from DB with body => {}", rider.getRiderId(), rider);
    }

    @PostRemove
    public void postRemove(Rider rider)
    {
        log.debug("postRemove : entity Rider with id=>{} is removed to DB with body => {}", rider.getRiderId(), rider);
    }
}
