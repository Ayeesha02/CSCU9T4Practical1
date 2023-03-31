// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord()
    {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public  String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
           Entry current = iter.next();
           if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
               result = current.getEntry();
       }
       return result;
   }
   // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }


    public String FindAllByDate(int d, int m, int y)
    {
        LinkedList<String> it = new LinkedList<>();
        for (Entry e : tr) {
            if (e.getDay() == d && e.getMonth() == m && e.getYear() == y) {
                it.add(String.valueOf(e));
                System.out.println("\n");
            }
        }
        if (it.size() == 0) {
            return "No records found on "+d+"/"+m+"/"+y ;
        }
        return it.toString();
    }

    public String lookupEntries(int d, int m, int y) //Looking up multiple entries
    {
        ListIterator<Entry> item = tr.listIterator();
        LinkedList<String> list = new LinkedList<>();
        while (item.hasNext()) {
            Entry current = item.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                list.add(current.getEntry());
            }
        }
        if (list.isEmpty()) {
            return "No entries found";
        } else {
            return list.toString();
        }
    }

        public void RemoveEntry ( int d, int m, int y, String n)//removal of entries
        {
            ListIterator<Entry> itr = tr.listIterator();
            boolean removed = false;
            while (itr.hasNext()) {
                Entry current = itr.next();
                if (current.getDay() == d && current.getMonth() == m && current.getYear() == y && current.getName().equals(n)) {
                    itr.remove();
                    System.out.println("Successful");
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                System.out.println("Failed");
            }
        }


    }


// TrainingRecord