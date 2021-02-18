package com.woqod.assignment.common;

public class Util {

    public static final String THE_USERNAME_OR_PASSWORD_IS_INCORRECT="THE USERNAME OR PASSWORD IS INCORRECT";


    public static boolean isBlank(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
