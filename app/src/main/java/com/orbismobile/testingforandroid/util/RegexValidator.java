package com.orbismobile.testingforandroid.util;

import java.util.regex.Pattern;

/**
 * Created by carlosleonardocamilovargashuaman on 8/8/17.
 */

public class RegexValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private static final Pattern NAME = Pattern.compile("^[\\\\-\\\\sABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚáéíóú ]+$");

    private static final Pattern PHONE = Pattern.compile("^(\\\\#[0-9]{6}|\\\\*[0-9]{6}|[0-9]{7}|\\\\#?[0-9]{9}|[0-9]{2}\\\\*[0-9]{3}\\\\*[0-9]{4})$");

    private static final Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑäëïöüÿÄËÏÖÜ ]+$");

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidName(String name) {
        return NAME.matcher(name).matches();
    }

    public static boolean isValidPhone(String phone) {
        return PHONE.matcher(phone).matches();
    }

    public static boolean isAlphaNumericString(String name) {
        return ALPHANUMERIC.matcher(name).matches();
    }
}
