package com.karpinskiy.andrew.diplom.entitys;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "distance_journal")
public class DistanceJournalEntity {
    @Id
    @GeneratedValue()
    private Long id;
    private Date date;
    private Integer distanceAmount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public DistanceJournalEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDistanceAmount() {
        return distanceAmount;
    }

    public void setDistanceAmount(Integer distanceAmount) {
        this.distanceAmount = distanceAmount;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
