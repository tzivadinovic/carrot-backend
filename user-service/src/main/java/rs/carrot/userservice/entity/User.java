package rs.carrot.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.EAGER;
import static rs.carrot.userservice.entity.domain.RecordStatus.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class User extends Auditable implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    @JsonProperty(access = WRITE_ONLY)
    private String password;
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(fetch = EAGER, cascade = MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_fk"), inverseJoinColumns = @JoinColumn(name = "role_fk"))
    private List<Role> roles;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return getRecordStatus() != EXPIRED;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return getRecordStatus() != LOCKED;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return getRecordStatus() != EXPIRED;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return getRecordStatus() != DISABLED && getRecordStatus() != DELETED;
    }


}