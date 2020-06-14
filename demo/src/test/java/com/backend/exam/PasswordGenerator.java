package com.backend.exam;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // encrypt admin/standard user credential
        String adminUser = "admin";
        String standardUser = "user";

        String encryptedAdminUser = encoder.encode(adminUser);
        System.out.println("admin: "+ encryptedAdminUser);

        String encryptedStandardUser = encoder.encode(standardUser);
        System.out.println("user : " + encryptedStandardUser);
    }


}
