package org.urfu.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdDate;

//    private List<Roles> roles       = new ArrayList<>();

//    public void addRole(Roles role) {
//        if (role != null && role.getId() != null) {
//            this.roles.add(role);
//        }
//    }
//    public boolean hasRole(String roleName) {
//        return roles.stream()
//                .anyMatch(r -> r.getName().equalsIgnoreCase(roleName));
//    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
