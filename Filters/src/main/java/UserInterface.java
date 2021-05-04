import Filters.*;
import PictureWorking.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private File inputFile, outputFile;
    private String filtersName;

    private void msgToUser(String msg) {
        System.out.println(msg);
    }

    private void checkFile(File file){
        if(!(file.exists() && file.isFile() && file.canWrite() && file.getName().endsWith(".bmp"))){
            msgToUser("Invalid file path\n");
            System.exit(-1);
        }
    }

    private void checkFilterName(String filterName)
    {
        boolean res = false;
        for(String i: FiltersName.filtersName){
            if (i.equalsIgnoreCase(filterName)) {
                res = true;
                break;
            }
        }

        if(!res){
            msgToUser("Invalid filters name\n");
            System.exit(-1);
        }
    }

    private void createFile(File file){
        if(!file.exists()){
            try{
                if(!file.createNewFile()){
                    msgToUser("Failed to create file\n");
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void input(){
        Scanner scanner = new Scanner(System.in);

        msgToUser("Please enter the path to the original image\n");
        inputFile = new File(scanner.nextLine());
        checkFile(inputFile);

        msgToUser("Please enter the filter name");
        filtersName = scanner.nextLine();
        checkFilterName(filtersName);

        msgToUser("Please enter the path to the original image\n");
        outputFile = new File(scanner.nextLine());
        createFile(outputFile);

    }
    
    public UserInterface(String inputFile, String outputFile, String filtersName)
    {
        File input = new File(inputFile);
        checkFile(input);
        File output = new File(outputFile);
        checkFilterName(filtersName);
        createFile(output);
        new PictureWorking(input, output, filtersName);
    }

    public UserInterface() {
        input();
        new PictureWorking(inputFile, outputFile, filtersName);
    }
}
