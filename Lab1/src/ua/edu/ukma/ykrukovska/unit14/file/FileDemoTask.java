package ua.edu.ukma.ykrukovska.unit14.file;

import acm.program.ConsoleProgram;

public class FileDemoTask extends ConsoleProgram {
    @Override
    public void run() {
        //1.
        //FileUtils.replaceInFile("", "", "");
        //2.
        String fileName = readLine();
        FileUtils.createFileBackup(fileName);
        FileUtils.splitFile(fileName);
        //3.


    }
}
