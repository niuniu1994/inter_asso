package com.efrei.inter_asso.entity;

import javafx.geometry.Pos;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ia_photos")
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photosId")
    private int photosId;

    private String img1;

    private String img2;

    private String img3;

    @OneToOne
    private Post post;
}

