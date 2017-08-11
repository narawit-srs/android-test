package com.orbismobile.testingforandroid;

import com.orbismobile.testingforandroid.util.RegexValidator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ValidateNameUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void validateName_withEmptyString() {
        assertFalse(RegexValidator.isValidName(""));
    }

    @Test
    public void validateName_withValidName() {
        assertTrue(RegexValidator.isValidName("Orbis Mobile"));
    }

    @Test
    public void validateName_withSpecialCharacters() {
        assertFalse(RegexValidator.isValidName("carlitos``"));
    }

    @Test
    public void validateName_withUppercaseCharacters() {
        assertTrue(RegexValidator.isValidName("CARLITOSDROID"));
    }

    @Test
    public void validateName_likeAnEmail() {
        assertFalse(RegexValidator.isValidName("carlos@gmail.com"));
    }

}