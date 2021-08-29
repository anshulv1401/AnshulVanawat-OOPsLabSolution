package com.greatlearning.service;

import com.greatlearning.model.Employee;
import java.util.Random;

public class CredentialGeneratorService {
    private Employee employee;
    private String emailAddress;
    private String password;

    public String generateEmailAddress(Employee employee) {
        this.employee = employee;
        return emailAddress = employee.getFirstName().toLowerCase() + employee.getLastName().toLowerCase() +
                "@" + employee.getDepartment() + ".greatlearning.com";
    }

    public String generatePassword() {
        Random random = new Random();
        final String validChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()<>_";

        char[] password = new char[8];
        for (int i = 0; i < 8; i++) {
            int idx = random.nextInt(validChar.length());
            password[i] = validChar.charAt(idx);
        }
        return this.password = String.valueOf(password);
    }

    public void showCredentials() {
        if (emailAddress == null) {
            System.out.println("Please generate email address before displaying credentials");
        }
        System.out.println("Dear " + employee.getFirstName() +
                ", your generated credentials are as follows"
                + "\nEmail --> " + emailAddress
                + "\nPassword --> " + (password != null ? password : generatePassword()));
    }
}
