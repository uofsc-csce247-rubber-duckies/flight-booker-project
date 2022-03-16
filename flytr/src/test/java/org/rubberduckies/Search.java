/** 
 * @author james-thurlow
 */
package test.java.org.rubberduckies;

import java.util.ArrayList;

import javax.naming.ldap.SortKey;

public class Search{
 
    private ArrayList<SortKey> sortKeys;
    private ArrayList<FilterKey> filterKeys;

    public Search(ArrayList<SortKey>sortKeys, ArrayList<FilterKey> filterKeys){
        System.out.println("Search.search");
    }

    public SortKey getSortKey(int index){
        System.out.println("Search.getSortKey");
        return null;
    }

    public FilterKey getFilterKey(int index){
        System.out.println("Search.getFilterKey");
        return null;
    }

}