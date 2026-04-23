package org.urfu.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {
    private String id;
    private String name;
    private String description;

    public Role(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
