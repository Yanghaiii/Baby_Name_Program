package com.babynameprogram;
import java.util.LinkedList;

public class Adding_Baby_Name {
    private LinkedList<Baby_Name> namelist;
    private Data_Write_Validation dwv = new Data_Write_Validation();

    public Adding_Baby_Name(LinkedList<Baby_Name> namelist) {
        this.namelist = namelist;
        System.out.println("Adding New Baby Name");
        System.out.println("----------------------");
    }

    public LinkedList<Baby_Name> read_File(String filepath, String year) {
        LinkedList<Baby_Name> newlist = new LinkedList<>();
        try {
            CSVReader cr = new CSVReader(new FileReader(filepath));
            String[] data;
            while ((data = cr.readNext()) != null){
                newlist.add(new Baby_Name(data[0], data[1], Integer.parseInt(year), 0, Integer.parseInt(data[2])));
            }
            cr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return newlist;
    }

    public void add_Name() {
        String filepath = dwv.get_File_Path();
        String year = dwv.get_Year();
        while (!dwv.valid_Year(year, namelist)) {
             year = dwv.get_Year();
        }

        LinkedList<Baby_Name> newlist = read_File(filepath, year);
        dwv.ranking(newlist, "M", year);
        dwv.ranking(newlist, "F", year);
        newlist.sort(Comparator.comparing(Baby_Name::getName));

        namelist.addAll(newlist);
        dwv.write(namelist);
        System.out.println("Successfully Added A New Baby Name By Year.");

    }
}
