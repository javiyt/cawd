package com.victormartin.projectcawd.presentation.presenters.impl;

import org.junit.Assert;
import org.junit.Test;

public class EmailCheckerTest {

    @Test
    public void testIsValidMail(){
        EmailChecker emailChecker = new EmailChecker("20158402K");
        final boolean valid = emailChecker.isValid();
        Assert.assertTrue(valid);
    }
}