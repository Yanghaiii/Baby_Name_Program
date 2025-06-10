package com.babynameprogram;

import java.util.LinkedList;

public class Delete_Baby_Name {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Delete_Baby_Name(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Deleting A Baby Name");
        System.out.println("--------------------");
    }

    public void delete_Name() {
        String searchName = dwv.get_Name();
        String searchGender = dwv.get_Gender();
        String searchYear = dwv.get_Year();

        int index;
        while ((index = dwv.search_Name(searchName, searchGender, searchYear, namelist)) < 0) {
            searchName = dwv.get_Name();
            searchGender = dwv.get_Gender();
            searchYear = dwv.get_Year();
        }

        namelist.remove(index);
        dwv.ranking(namelist, searchGender, searchYear);
        dwv.write(namelist);
        System.out.println("Successfully Deleted A Baby Name.");

    }
}
