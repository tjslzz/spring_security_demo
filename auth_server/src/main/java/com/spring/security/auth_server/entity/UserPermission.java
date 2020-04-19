package com.spring.security.auth_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USER_PERMISSION")
@Getter
@Setter
public class UserPermission {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "PERMISSION_ID", nullable = false)
    private String permissionID;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID",foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    @JsonIgnore
    private UserRole userRole;

    @Column(name = "PERMISSION_NAME")
    private String permissionName;


}
