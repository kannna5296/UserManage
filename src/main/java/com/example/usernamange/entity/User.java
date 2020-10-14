package com.example.usernamange.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name="users")
public class User implements Serializable {

    /**
     * ID
     */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;

    /**
     * 名前
     */
    @Column(name="name")
    public String name;

    /**
     * 年齢
     */
    @Column(name="age")
    public int age;

    /**
     * 登録日時
     */
    @Column(name="created_date")
    public Date createdDate;

    /**
     * 更新日時
     */
    @Column(name="updated_date")
    public Date updatedDate;
}