package com.automorfosi.mathisi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Document(collection = "user_details")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Id
    private ObjectId id;

    private String orgId;

    private String orgName;

    private String email;
    private String firstname;

    private String middleName;
    private String lastname;

    private String password;

    private UserRole role;


    //Indicates whether the user's account is non-expired.
    private boolean accountNonExpired;

    // Indicates whether the user's account is non-locked.
    private boolean accountNonLocked;

    //Indicates whether the user's credentials (password) are non-expired
    private boolean credentialsNonExpired;

    //Indicates whether the user is enabled.
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    } //todo work on the Authority

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
