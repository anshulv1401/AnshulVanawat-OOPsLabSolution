package com.greatlearning.main;

import com.greatlearning.model.Employee;
import com.greatlearning.service.CredentialGeneratorService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input first name");
        String firstName = sc.nextLine();

        System.out.println("Input last name");
        String lastName = sc.nextLine();

        System.out.println("Please enter the department from the following"
                + "\n1. Technical"
                + "\n2. Admin"
                + "\n3. Human Resource"
                + "\n4. Legal");

        int departmentId;
        try {
            departmentId = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input : Expected integer value");
            return;
        }

        String departmentCode;
        switch (departmentId) {
            case 1:
                departmentCode = "tech";
                break;
            case 2:
                departmentCode = "adm";
                break;
            case 3:
                departmentCode = "hr";
                break;
            case 4:
                departmentCode = "lg";
                break;
            default:
                System.out.println("Invalid selection");
                return;
        }

        Employee employee = new Employee(firstName, lastName, departmentCode);

        CredentialGeneratorService credentialService = new CredentialGeneratorService();
        credentialService.generateEmailAddress(employee);
        credentialService.showCredentials();
    }
}
