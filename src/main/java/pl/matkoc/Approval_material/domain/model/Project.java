package pl.matkoc.Approval_material.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter @Setter @ToString
public class Project extends ParentEntity{

    @Column(nullable = false, unique = true)
    private Long number;
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "project")
    private List<Material> materialsList = new ArrayList<>();
}
