package pack;

import java.util.HashMap;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HistogramAlphaBet {
    private HashMap<Character, Integer> frequency;
    private Scanner scan;
    private final String FILE;

    public HistogramAlphaBet(String fileName) {
        frequency = new HashMap<>();
        FILE = fileName;
        for (char temp = 'a'; temp <= 'z'; ++temp){ frequency.put(temp,0); }
    }
    public void openFile(){
        try{ scan = new Scanner(Paths.get(FILE)); }
        catch(IOException e){ System.out.println("Unable to open file."); }
    }
    public void closeFile(){ if (scan != null) scan.close(); }
    public HashMap frequencyOfLetters(){
        openFile();
        String line; Character letter;
        try{
            while (scan.hasNext()){
                line = scan.nextLine().replaceAll("[^a-zA-Z]","").toLowerCase();
                for (int i = 0; i < line.length(); ++i){
                    letter = line.charAt(i);
                    frequency.put(letter,frequency.get(letter) + 1);
                }
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println(e);
        }
        closeFile();
        return frequency;
    }
}
