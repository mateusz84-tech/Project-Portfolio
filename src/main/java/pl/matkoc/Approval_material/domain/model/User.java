package pl.matkoc.Approval_material.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = "password", callSuper = true)
public class User extends ParentEntity {

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<Material> materialsList = new ArrayList<>();

    @ManyToOne
    private Project project;

}
