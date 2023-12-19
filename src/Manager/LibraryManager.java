package Manager;

import Entity.LibraryEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LibraryManager {

    public static List<LibraryEntity> ReadFile()  {
        try {

            Scanner scanner = new Scanner(new File("src/file.txt"));
            List<LibraryEntity> list = new ArrayList<>();

            while(scanner.hasNextLine()){
                String MainString = scanner.nextLine();

                list.add(new LibraryEntity(
                        Integer.parseInt(returnString(MainString,0)),
                        returnString(MainString,1),
                        returnString(MainString,2),
                        Integer.parseInt(returnString(MainString,3))
                ));
            }
            return list;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

        public static void SaveFile(){
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/file.txt"));

                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String returnString(String str, int index){
            String[] words = str.split(";");
            String rtnStr = " ";
            for(String word: words){
                rtnStr = words[index];
            }
            return rtnStr;
    }
}
