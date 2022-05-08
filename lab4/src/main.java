import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static java.nio.file.Files.copy;
import static java.util.stream.Collectors.toList;
//import static sun.nio.fs.UnixCopyFile.copyDirectory;


public class main {
    public static void main(String[] args) throws Exception{
        String first = "C:\\Users\\пк\\Desktop\\sfqk";
        String second = "C:\\Users\\пк\\Desktop\\afqk2";
        //FileWriter writer = new FileWriter("C:\\Users\\пк\\Desktop\\afqk2\\data.txt");

        try {
            copyDir(first, second);
        }
        catch (IOException e){
            e.printStackTrace();
        }


        System.out.println("Назва файлів, що скопіювались:");
        FileWriter fw = new FileWriter("C:\\Users\\пк\\Desktop\\afqk2\\data.txt");
        File folder = new File("C:\\Users\\пк\\Desktop\\sfqk");
        for (File file : folder.listFiles()) {
            System.out.println(file.getName());
            fw.write(file.getName() + "\n");


        }
        fw.close();

    }

    private static void copyDir(String sourceDirName, String targetSourceDir) throws IOException {
        File folder = new File(sourceDirName);

        File[] listOfFiles = folder.listFiles();

        Path destDir = Paths.get(targetSourceDir);
        if (listOfFiles != null)
            for (File file : listOfFiles)
                Files.copy(file.toPath(), destDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
    }

}