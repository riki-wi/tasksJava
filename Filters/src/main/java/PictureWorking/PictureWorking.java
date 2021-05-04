package PictureWorking;


import Filters.ToGrey;

import java.io.File;
import java.util.Arrays;


public class PictureWorking {

    public PictureWorking(File inputFile, File outputFile, String filtersName){
        new PictureReader(inputFile);
        new ToGrey().workWithFilter(PictureStruct.image, PictureStruct.height, PictureStruct.width);
        new PictureWriter(outputFile);
        System.out.println("All ok!!!");
    }
}
