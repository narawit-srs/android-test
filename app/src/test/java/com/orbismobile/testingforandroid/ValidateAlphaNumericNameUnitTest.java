package com.orbismobile.testingforandroid;

import com.orbismobile.testingforandroid.util.RegexValidator;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidateAlphaNumericNameUnitTest {

    @Test
    public void validateAlphaNumericName_withEmptyString() {
        assertTrue(RegexValidator.isAlphaNumericString("carlo12jan12andres12"));
    }

    @Test
    public void validateAlphaNumericName_withSpaces() {
        assertTrue(RegexValidator.isAlphaNumericString("Orbis Mobile"));
    }

    @Test
    public void validateAlphaNumericName_withoutNumbers() {
        assertTrue(RegexValidator.isAlphaNumericString("carlitos"));
    }

}