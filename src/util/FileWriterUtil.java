package util;

import contants.ShowConstants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;


public class FileWriterUtil {

    public static void writeOutputToFile(String str) {
        try {if(str!=""){
            Path filePath = Paths.get(ShowConstants.outputFilePath);
                           Files.write(filePath, Collections.singleton(str.replace("[","").replace("]","")),
                        new StandardOpenOption[]{StandardOpenOption.APPEND});}
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}