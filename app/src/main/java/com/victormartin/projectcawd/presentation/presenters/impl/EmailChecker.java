package com.victormartin.projectcawd.presentation.presenters.impl;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {

    private String identifier;

    public EmailChecker(String identifier) {
        this.identifier = identifier;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean isValid() {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(this.identifier);
        return matcher.find();
    }
    
}
