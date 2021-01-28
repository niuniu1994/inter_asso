package com.efrei.inter_asso.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ia_school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private int schoolId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = true)
    private String icon;

    @OneToMany(mappedBy = "school",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Association> set = new HashSet<>();

    public void addAssociation(Association association){
        association.setSchool(this);
        set.add(association);
    }

    public void removeAssociation(Association association){
        set.remove(association);
        association.setSchool(null);
    }

}
