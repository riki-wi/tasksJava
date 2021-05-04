package Filters;

import java.util.ArrayList;
import java.util.Arrays;

public class FiltersName {
    public static ArrayList<String> filtersName = new ArrayList<>(Arrays.asList("toGrey", "Gauss3x3"));

    public static void addFilters(String filtersNameString)
    {
        filtersName.add(filtersNameString);
    }
}
