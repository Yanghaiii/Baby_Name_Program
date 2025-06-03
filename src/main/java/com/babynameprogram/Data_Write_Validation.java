package com.babynameprogram;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
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
    public void ranking(LinkedList<Baby_Name> namelist, String gender, String year) {
        LinkedList<Baby_Name> ranklist = new LinkedList<>();
        for (Baby_Name b : namelist) {
            if (b.getGender().equals(gender) && b.getYear() == Integer.parseInt(year)) {
                ranklist.add(b);
            }
        }
        namelist.removeAll(ranklist);

        ranklist.sort(Collections.reverseOrder(Comparator.comparing(Baby_Name::getCount)));
        int rank = 0;
        int prev_count = 0;
        for (Baby_Name b : ranklist) {
            if (b.getCount() != prev_count) {
                rank++;
            }
            b.setRank(rank);
            prev_count = b.getCount();
        }

        namelist.addAll(ranklist);
    }

    public void write(LinkedList<Baby_Name> namelist) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("data/Baby_Names.csv", false)); // renewing/modifying data
            pw.println("name,gender,year,rank,count");
            for (Baby_Name b: namelist) {
                pw.println(b.getName() + "," +b.getGender() +"," +b.getYear() +"," +b.getRank() +"," +b.getCount());
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get_File_Path() {
        System.out.println("Enter File Path: ");
        String filepath = sc.nextLine();
        while (filepath.isEmpty()) {
            System.out.println("File path must not be empty");
            System.out.println("Enter File Path: ");
            filepath = sc.nextLine();
        }
        if (!new File(filepath).exists()) {
            System.out.println("File does not exist.");
            filepath = get_File_Path();
        }
        return filepath;
    }

}
