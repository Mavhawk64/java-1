import java.util.*;
import java.io.*;
/**
 * Write a description of class FileReading here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileReading
{
    public static void main(String[] args)
    {    
        System.out.println(new File("letters.txt").getAbsoluteFile());
        File file = new File("C:/Users/mavbe/Desktop/Coding Folder/CodingCompetitions/");
        System.out.println(file.list());
    }
}
