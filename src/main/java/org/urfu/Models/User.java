package org.urfu.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private Date createdDate;

    public User(String id, String name, String email, String password, Date createdDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
    }
}
