package com.efrei.inter_asso.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ia_friends")
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friends_id")
    private int friendsId;

    @Column(name = "user_id",nullable = false)
    private int userId;

    @Column(name = "friend_id",nullable = false)
    private int friendId;
}
