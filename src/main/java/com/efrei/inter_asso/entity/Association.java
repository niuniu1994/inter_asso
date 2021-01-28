package com.efrei.inter_asso.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ia_association")
public class Association {

    @Id
    @Column(name = "asso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String assoId;

    @Column(name = "category",nullable = false)
    private String category;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "about", nullable = true)
    private String about;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "admin_id",nullable = false)
    private int adminId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime = LocalDateTime.now();


    @Column(name = "status", nullable = false)
    private int status = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    @ManyToMany(mappedBy = "associations")
    private Set<User> users = new HashSet<>();
}
