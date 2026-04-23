package org.urfu.validator;

import org.springframework.stereotype.Component;
import org.urfu.Models.User;

@Component
public class Validator {
    public boolean UserCheckValid(User user) {

        if (user.getName() == null || user.getName().length() < 4)
            return false;

        if (user.getEmail() == null || user.getEmail().length() < 6)
            return false;

        if (user.getPassword() == null || user.getPassword().length() < 6)
            return false;

        return true;
    }
}
