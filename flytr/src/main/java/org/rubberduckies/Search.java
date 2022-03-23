package org.rubberduckies;

import java.util.ArrayList;

public class Search{
 
    private ArrayList<SortKey> sortKeys;
    private ArrayList<FilterKey> filterKeys;

    public Search(ArrayList<SortKey>sortKeys, ArrayList<FilterKey> filterKeys){
        this.sortKeys = sortKeys;
        this.filterKeys = filterKeys;
    }

    public ArrayList<SortKey> getSortKey(){
        return sortKeys;
    }

    public void setSortKeys(ArrayList<SortKey> sortKeys) {
        this.sortKeys =sortKeys;
    }

    public ArrayList<FilterKey> getFilterKey(){
       return filterKeys;
    }

    public void setFilterKeys(ArrayList<FilterKey> filterKeys) {
        this.filterKeys = filterKeys;
    }
}
