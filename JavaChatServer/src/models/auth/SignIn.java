package models.auth;

import interfaces.Validation;

public class SignIn implements Validation {
    public String login;
    public String password;

    @Override
    public boolean isValidate() {
        return (login != null && !login.isEmpty()
                && password != null && !password.isEmpty()) ? true : false;
    }
}
