package com.phonpe.cabmanagement.listener;

import com.phonpe.cabmanagement.domain.Trip;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class TripEntityListener
{
    @PrePersist
    public void prePersist(Trip trip)
    {
        log.debug("prePersist : entity Trip with id=>{} will be persisted to DB with body => {}", trip.getTripId(), trip);
    }

    @PostPersist
    public void postPersist(Trip trip)
    {
        log.debug("postPersist : entity Trip with id=>{} is persisted to DB with body => {}", trip.getTripId(), trip);
    }

    @PreUpdate
    public void preUpdate(Trip trip)
    {
        log.debug("preUpdate : entity Trip with id=>{} will be updated to DB with body => {}", trip.getTripId(), trip);
    }

    @PostUpdate
    public void postUpdate(Trip trip)
    {
        log.debug("postUpdate : entity Trip with id=>{} is updated to DB with body => {}", trip.getTripId(), trip);
    }

    @PreRemove
    public void preRemove(Trip trip)
    {
        log.debug("preRemove : entity Trip with id=>{} will be removed from DB with body => {}", trip.getTripId(), trip);
    }

    @PostRemove
    public void postRemove(Trip trip)
    {
        log.debug("postRemove : entity Trip with id=>{} is removed to DB with body => {}", trip.getTripId(), trip);
    }
}
