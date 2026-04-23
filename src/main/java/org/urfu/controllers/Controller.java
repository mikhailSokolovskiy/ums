package org.urfu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.urfu.Models.User;
import org.urfu.constants.Constants;
import org.urfu.dao.UmsRepository;
import org.urfu.validator.Validator;

import java.util.HashMap;
import java.util.Map;


@RestController
public class Controller {

    @Autowired
    UmsRepository repo;

    @GetMapping("/ums")
    public String getUms() {
        return "hello";
    }

    @PostMapping("/ums")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        //TODO: шаг 1: валидация
        //      шаг 2: сформировать sql основываясь на USER
        //      шаг 3: записать данные в базу
        Validator valid = new Validator();
        if (!valid.UserCheckValid(user)) {
            response.put(Constants.CODE, "500");
            response.put(Constants.MESSAGE, "User is not valid");
            response.put(Constants.DATA, null);
            return ResponseEntity.ok()
                    .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                    .header(Constants.ACCEPT, Constants.APPLICATION_JSON)
                    .body(response);
        }

        repo.createUser(user);

        if (user.getId() == null) {
            response.put(Constants.CODE, "500");
            response.put(Constants.MESSAGE, "User has not been created — check for duplicate e-mail");
            response.put(Constants.DATA, null);
        } else {
            response.put(Constants.CODE, "201");
            response.put(Constants.MESSAGE, "User created");
            response.put(Constants.DATA, user.getId());
        }

        return ResponseEntity.ok()
                .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                .header(Constants.ACCEPT, Constants.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/ums")
    public String putUser(User user) {
        return "";
    }

    @DeleteMapping("/ums")
    public String deleteUser(String id) {
        return "";
    }
}
