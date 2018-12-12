package ua.edu.ukma.ykrukovska.unit14.file;

import ua.edu.ukma.ykrukovska.unit14.utils.StringUtils;

import java.io.*;

public class FileUtils {
    public static void replaceInFile(String fileName, String find, String replace) {
        //check params
        if (fileName == null || fileName.isEmpty() || find == null || find.isEmpty() || replace == null || replace.isEmpty()) {
            //do nothing if params are not valid
            return;
        }

        try (
                BufferedReader inputData = new BufferedReader(new FileReader(fileName)); // input data
                PrintWriter outputData = new PrintWriter(fileName)//output data
        ) {

            String line = inputData.readLine();

            while (line != null) {
                //add  string with replaced substring into output file
                outputData.println(StringUtils.replaceSubstring(line, find, replace));
                line = inputData.readLine();
            }

        } catch (Exception e) {
            //something wrong happened
        }


    }
}
