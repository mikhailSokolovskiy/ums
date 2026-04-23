package org.urfu.dao;

import org.urfu.Models.User;

import java.util.UUID;

public interface UmsRepository {
    public UUID createUser(User user);
}
