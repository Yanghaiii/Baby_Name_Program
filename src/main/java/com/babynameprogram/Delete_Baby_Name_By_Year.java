package com.babynameprogram;

import java.util.LinkedList;

public class Delete_Baby_Name_By_Year {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Delete_Baby_Name_By_Year(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Deleting A Baby Name By Year");
        System.out.println("--------------------");
    }

    public void delete_Name() {
        String searchYear = dwv.get_Year();
        while (dwv.valid_Year(searchYear, namelist)) {
            searchYear = dwv.get_Year();
        }

        LinkedList<Baby_Name> deletelist = new LinkedList<>();
        for (Baby_Name b: namelist) {
            if (b.getYear() == Integer.parseInt(searchYear)) {
                deletelist.add(b);
            }
        }
        namelist.removeAll(deletelist); // dont' delete in FOR loop, it's safest
        dwv.write(namelist);
        System.out.println("Successfully Deleted A Baby Name By year.");

    }
}
