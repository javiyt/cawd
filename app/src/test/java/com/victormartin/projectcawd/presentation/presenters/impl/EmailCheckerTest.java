package com.victormartin.projectcawd.presentation.presenters.impl;

import org.junit.Assert;
import org.junit.Test;

public class EmailCheckerTest {

    @Test
    public void testIsValidMail(){


        EmailChecker emailChecker2 = new EmailChecker("victor");
        final boolean valid2 = emailChecker2.isValid();
        Assert.assertFalse(valid2);
    }
}