package com.babynameprogram;

import java.util.LinkedList;
import java.util.Scanner;

public class Data_Write_Validation {

    private Scanner sc = new Scanner(System.in);

    protected String get_Name() {
        System.out.println("Enter Baby Name :");
        String name = sc.nextLine();

        if (!name.matches("[A-Z][a-z]{1,9}")) {
            System.out.println("Enter only name in at least 2 letters in capitalized first letter.");
            name = get_Name();
        }
        return name;
    }

    protected String get_Gender() {
        System.out.println("Enter Gender :");
        String gender = sc.nextLine();

        if (!gender.matches("[M|F]")) {
            System.out.println("Enter only gender in M or F.");
            gender = get_Name();
        }
        return gender;
    }

    protected String get_Year() {
        System.out.println("Enter Year :");
        String year = sc.nextLine();

        if (!year.matches("[1-9][0-9]{3}")) {
            System.out.println("Enter only year in 4 digit numbers.");
            year = get_Name();
        }
        return year;
    }

    protected String get_Count() {
        System.out.println("Enter Count :");
        String count = sc.nextLine();

        if (!count.matches("[1-9][0-9]{0,5}")) {
            System.out.println("Enter only count in numbers within 5 digits.");
            count = get_Name();
        }
        return count;
    }

    protected boolean valid_Name(String name, String gender, String year, LinkedList<Baby_Name> namelist) {
        for (Baby_Name b: namelist) {
            if (b.getName().equals(name) && b.getGender().equals(gender) && b.getYear() == Integer.parseInt(year)) {
                System.out.println("Name already exists.");
                return false;
            }
        }
        return true;
    }
}
