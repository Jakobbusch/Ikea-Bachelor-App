package com.example.ikeabachelorapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataItems {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableDetailList = new HashMap<String, List<String>>();

        // As we are populating List of fruits, vegetables and nuts, using them here
        // We can modify them as per our choice.
        // And also choice of fruits/vegetables/nuts can be changed
        List<String> Tables = new ArrayList<String>();
        Tables.add("null");


        List<String> Cabinets = new ArrayList<String>();
        Cabinets.add("null");


        List<String> Beds = new ArrayList<String>();
        Beds.add("null");


        // Fruits are grouped under Fruits Items. Similarly the rest two are under
        // Vegetable Items and Nuts Items respecitively.
        // i.e. expandableDetailList object is used to map the group header strings to
        // their respective children using an ArrayList of Strings.
        expandableDetailList.put("Tables", Tables);
        expandableDetailList.put("Cabinets", Cabinets);
        expandableDetailList.put("Beds", Beds);
        return expandableDetailList;
    }
}
