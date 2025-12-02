package uasz.alumni.ms_user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import uasz.alumni.ms_user.common.entities.BaseEntity;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(
    name = "roles",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_role_libelle", columnNames = "libelle")
    }
)
public class Role extends BaseEntity {

    @Column(nullable = false, unique = true, length = 100)
    private String libelle;

}
