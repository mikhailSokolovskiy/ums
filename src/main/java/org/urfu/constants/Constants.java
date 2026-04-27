package org.urfu.constants;

public class Constants {
    public static final String MESSAGE = "message";
    public static final String DATA = "data";
    public static final String CODE = "code";
    public static final String APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCEPT = "Accept";
    public static final String GET_ALL_ROLES = "";
    private static final String TABLE_USERS = "ums.users";
    public static final String CREATE_USER = "INSERT INTO " + TABLE_USERS +
            " (id, name, email, password, created) " +
            "VALUES (UUID_TO_BIN(?), ?, ?, ?, ?)";
    public static final String ASSIGN_ROLE = "";

}
