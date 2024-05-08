package tp5_2;

import java.io.*;

public class TestCopy {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("D:\\fichiers\\in.txt");
        File outputFile = new File("D:\\fichiers\\out.txt");
        
        FileReader reader = new FileReader(inputFile);
        FileWriter writer = new FileWriter(outputFile);
        
        int character;
        while ((character = reader.read()) != -1) {
            writer.write(character);
            System.out.print((char) character); // Impression du caractère en tant que char
        }
        
        reader.close();
        writer.close();
    }
}
