package com.phonpe.cabmanagement.listener;

import com.phonpe.cabmanagement.domain.Cab;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class CabEntityListener
{
    @PrePersist
    public void prePersist(Cab cab)
    {
        log.info("prePersist : entity booking with id=>{} will be persisted to DB with body", cab.getCabId(), cab);
    }

    @PostPersist
    public void postPersist(Cab cab)
    {
        log.info("postPersist : entity booking with id=>{} is persisted to DB with body", cab.getCabId(), cab);
    }

    @PreUpdate
    public void preUpdate(Cab cab)
    {
        log.info("preUpdate : entity booking with id=>{} will be updated to DB with body", cab.getCabId(), cab);
    }

    @PostUpdate
    public void postUpdate(Cab cab)
    {
        log.info("postUpdate : entity booking with id=>{} is updated to DB with body", cab.getCabId(), cab);
    }

    @PreRemove
    public void preRemove(Cab cab)
    {
        log.info("preRemove : entity booking with id=>{} will be removed from DB with body", cab.getCabId(), cab);
    }

    @PostRemove
    public void postRemove(Cab cab)
    {
        log.info("postRemove : entity booking with id=>{} is removed to DB with body", cab.getCabId(), cab);
    }
}
