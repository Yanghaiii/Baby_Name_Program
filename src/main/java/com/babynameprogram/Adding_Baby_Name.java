package com.babynameprogram;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Adding_Baby_Name {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Adding_Baby_Name(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Adding New Baby Name");
        System.out.println("--------------------");
    }

    public void add_Name() {
        String name = dwv.get_Name();
        String gender = dwv.get_Gender();
        String year = dwv.get_Year();
        while (!dwv.valid_Name(name, gender, year, namelist)) {
            name = dwv.get_Name();
            gender = dwv.get_Gender();
            year = dwv.get_Year();
        }
        String count = dwv.get_Count();

        namelist.add(new Baby_Name(name, gender, Integer.parseInt(year), 0, Integer.parseInt(count)));
        dwv.ranking(namelist, gender, year);
        dwv.write(namelist);
        System.out.println("Successfully added a new baby name.😍😍");
    }
}
