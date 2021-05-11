package com.karpinskiy.andrew.diplom.entitys;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weight_journal")
public class WeightJournalEntity {
    @Id
    @GeneratedValue()
    private Long id;
    private Date date;
    private Integer weight;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public WeightJournalEntity() {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
