package com.karpinskiy.andrew.diplom.entitys;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calories_journal")
public class CaloriesJournalEntity {
    @Id
    @GeneratedValue()
    private Long id;
    private Date date;
    private Integer caloriesAmount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public CaloriesJournalEntity() {
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

    public Integer getCaloriesAmount() {
        return caloriesAmount;
    }

    public void setCaloriesAmount(Integer caloriesAmount) {
        this.caloriesAmount = caloriesAmount;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
