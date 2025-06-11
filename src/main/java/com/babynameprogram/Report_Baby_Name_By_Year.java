package com.babynameprogram;

import java.util.LinkedList;

public class Report_Baby_Name_By_Year {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Report_Baby_Name_By_Year(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Deleting A Baby Name By Year");
        System.out.println("--------------------");
    }

    public void report_Name() {
        String searchYear = dwv.get_Year();
        while (dwv.valid_Year(searchYear, namelist)) {
            searchYear = dwv.get_Year();
        }

        LinkedList<Baby_Name> malelist = new LinkedList<>();
        LinkedList<Baby_Name> femalelist = new LinkedList<>();

        for (Baby_Name b: namelist) {
            if (b.getYear() == Integer.parseInt(searchYear)) {
                if (b.getGender().equals("M")) {
                    malelist.add(b);
                }
                else {
                    femalelist.add(b);
                }
            }
        }

        System.out.println(".");

    }
}
