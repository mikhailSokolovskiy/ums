package org.urfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.urfu.Models.Roles;
import org.urfu.Models.User;
import org.urfu.constants.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserDAO implements UmsRepository {


    @Autowired
    private JdbcTemplate jdbc;

    public UUID createUser(User user) {
        UUID userId = UUID.randomUUID();
//        Map<String, Roles> roleMap = findAllRoles();
        user.setId(userId);
        try {
            jdbc.update(Constants.CREATE_USER,
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPassword());

//            for (Roles role : user.getRoles()) {
//                Roles canonical = roleMap.get(role.getName().toUpperCase());
//                if (canonical == null) {
//                    // Unknown role name — skip rather than crash
//                    continue;
//                }
//                jdbc.update(Constants.ASSIGN_ROLE,
//                        userId.toString(),
//                        canonical.getId().toString());
//            }
        } catch (Exception e) {
            // Likely a duplicate e-mail — caller gets null as "failed" signal
            return null;
        }
        return userId;
    }


    public Map<String, Roles> findAllRoles() {
        Map<String, Roles> result = new HashMap<>();
        jdbc.query(Constants.GET_ALL_ROLES, ROLE_ROW_MAPPER)
                .forEach(r -> result.put(r.getName(), r));
        return result;
    }

    // ----------------------------------------------------------------
    // Row mappers
    // ----------------------------------------------------------------

    /**
     * Maps a single JOIN row (user + one role) to a User object.
     * Callers are responsible for merging multi-role rows.
     */
    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> {
        User user = new User();
        user.setId(DaoHelper.bytesArrayToUuid(rs.getBytes("u.id")));
        user.setName(rs.getString("u.name"));
        user.setEmail(rs.getString("u.email"));
        user.setPassword(rs.getString("u.password"));
        user.setCreatedDate(rs.getObject("u.created", java.time.LocalDateTime.class));

        // Role column may be NULL when user has no roles (LEFT JOIN)
//        byte[] roleIdBytes = rs.getBytes("role_id");
//        if (roleIdBytes != null) {
//            Roles role = new Roles(
//                    DaoHelper.bytesArrayToUuid(roleIdBytes),
//                    rs.getString("role_name"),
//                    rs.getString("role_desc"));
//            user.addRole(role);
//        }
        return user;
    };

    private static final RowMapper<Roles> ROLE_ROW_MAPPER = (rs, rowNum) -> new Roles(
            DaoHelper.bytesArrayToUuid(rs.getBytes("id")),
            rs.getString("name"),
            rs.getString("description"));


}


