package com.efrei.inter_asso.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ia_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Permission> permissionSet = new HashSet<>();

    public void addPermission(Permission permission){
        permissionSet.add(permission);
        permission.setRole(this);
    }


    public void removePermission(Permission permission){
        permissionSet.remove(permission);
        permission.setRole(null);
    }
}
