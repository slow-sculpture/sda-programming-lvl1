package pl.sda.poznan.jvm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//Napisac program ktory odczytuje linie z pliku
public class FileOperation {
    public static List<String> readLinesFromFile(String path) {
        List<String> result = null;
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    //stary sposob ktory byl na zajeciach wprowadzajacych
    public List<String> linesFromFile(String path) {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }



}
