package uz.md.shopapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import uz.md.shopapp.domain.enums.PermissionEnum;
import uz.md.shopapp.domain.template.AbsLongEntity;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Where(clause = "deleted = false")
@SQLDelete(sql = "update role SET deleted = true where id = ?")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean deleted = false;

    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @CollectionTable(name = "role_permission",
            joinColumns =
            @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Column(name = "permission", nullable = false)
    private Set<PermissionEnum> permissions;

    public <E> Role(String name, String description, Set<PermissionEnum> permissions) {
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        return getId() != null && getId().equals(((Role) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
