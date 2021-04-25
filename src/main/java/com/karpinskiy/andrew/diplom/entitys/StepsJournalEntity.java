package com.karpinskiy.andrew.diplom.entitys;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "steps_journal")
public class StepsJournalEntity {
    @Id
    @GeneratedValue()
    private Long id;
    private Date date;
    private Integer stepsAmount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public StepsJournalEntity() {
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

    public Integer getStepsAmount() {
        return stepsAmount;
    }

    public void setStepsAmount(Integer stepsAmount) {
        this.stepsAmount = stepsAmount;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
