package rs.carrot.productservice.entity.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rs.carrot.productservice.entity.Auditable;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Auditable implements UserDetails {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String username;
    @JsonProperty(access = WRITE_ONLY)
    private String password;
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
