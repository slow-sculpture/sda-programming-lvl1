package pl.sda.poznan.jvm;

import java.util.List;

public class App {
    public static  final String PATH_TO_FILE = "C:\\Users\\chris\\IdeaProjects\\sda-programming-lvl1\\src\\pl\\sda\\poznan\\jvm\\plik.txt";

    //polacz wszystkie napisy z listy w 1 napis
    //metoda niewydajna po kazkorazowo tworzy nowy napis ze starego napisu i nowej linii
    //stare pozostaja w pamieci ktore musi oczyszczac GC
    private static String concatanateStringsBadExample(List<String> list) throws InterruptedException {
        String result = null;

        for (String line : list) {
            result += line;
            Thread.sleep(100);
        }
        return result;
    }

    //metoda z builderem znacznie ogranicza zuzycie pamieci
    private static String concatanateStringsWithBuilder(List<String> list)throws InterruptedException{
        StringBuilder builder = new StringBuilder();
        for(String line:list){
            builder.append(line);
            Thread.sleep(100);
        }
        return builder.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> lines = FileOperation.readLinesFromFile(PATH_TO_FILE);
        System.out.println("Wczytano: " + lines.size() + " linii...");
       // String wszystkieLinie = concatanateStringsBadExample(lines);
        String allLines = concatanateStringsWithBuilder(lines);
        System.out.println();
    }
}
