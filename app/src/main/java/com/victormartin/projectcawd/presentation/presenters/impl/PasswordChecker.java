package com.victormartin.projectcawd.presentation.presenters.impl;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {

    public static final Pattern VALID_CHARACTERS_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]{8,128}$", Pattern.CASE_INSENSITIVE);

    private String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public boolean isValid() {
        Matcher matcher = VALID_CHARACTERS_ADDRESS_REGEX.matcher(this.password);
        return matcher.find();
    }
    
}