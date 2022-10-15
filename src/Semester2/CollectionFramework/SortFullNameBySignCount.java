package Semester2.CollectionFramework;

import java.util.Comparator;

public class SortFullNameBySignCount implements Comparator<FullName> {
    @Override
    public int compare(FullName firstFullName, FullName secondFullName) {
        int signCountFirstFullName = firstFullName.getName().length() + firstFullName.getFamily_name().length();
        int signCountSecondFullName = secondFullName.getName().length() + secondFullName.getFamily_name().length();
        return signCountFirstFullName - signCountSecondFullName; //--> Bei Compare: Wert<0 -_> o1 erst, Werte gleich --> o1,o2 gleich, Wert>0 --> o2 erst
    }
}
