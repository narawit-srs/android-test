package com.orbismobile.testingforandroid;

import com.orbismobile.testingforandroid.util.RegexValidator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidateEmailNameUnitTest {

    @Test
    public void validateEmail_withEmptyString() {
        assertFalse(RegexValidator.isValidEmail(""));
    }

    @Test
    public void validateEmail_withInitialNumbers() {
        assertTrue(RegexValidator.isValidEmail("carlitosdroid12@gmail.com"));
    }

    @Test
    public void validateEmail_withoutDot() {
        assertFalse(RegexValidator.isValidEmail("carlitos@gmailcom"));
    }

}