package org.home.entity;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {
    public static class Roles {

        private final static List<String> roles = Arrays.asList(Constants.Roles.USER, Constants.Roles.ADMIN);

        public static boolean exists(@NonNull String role) {
            return roles.contains(role);
        }

        public final static String USER = "USER";
        public final static String ADMIN = "ADMIN";

    }

    public static class Messages {
        public static String NOT_AUTHENTICATED = "Please, login first";
        public static String USER_NOT_FOUND = "User not found";
    }

}
