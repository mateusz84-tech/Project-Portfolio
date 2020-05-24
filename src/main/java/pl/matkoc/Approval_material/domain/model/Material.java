package pl.matkoc.Approval_material.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "material")
@Getter @Setter @ToString
public class Material extends ParentEntity{

    @Column(nullable = false, unique = true)
    private String materials;
    @Column(nullable = false)
    private String description;
    private String approved;
    private String comments;
    @Column(name = "created_on")
    private LocalTime created;
    @Column(name = "updated_on")
    private LocalTime updated;

    @PrePersist
    public void prePersist(){
        created = LocalTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated = LocalTime.now();
    }

    @ManyToOne
    private User user;

    @ManyToOne
    private Material material;


}
