package pl.matkoc.Approval_material.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "inspectors")
@Getter @Setter @ToString
public class Inspector extends ParentEntity {

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false, unique = true)
    private String industry;

    @ManyToOne
    private Project project;
}
