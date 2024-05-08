package tp5_4;

import java.io.*;

public class FileEncryption {
    public static void main(String[] args) {
        String sourceFilePath = "in.txt";
        String destinationFilePath = "UsersEncrypted.txt";
        cryptage(sourceFilePath, destinationFilePath);
        System.out.println("Fichier crypté avec succès !");
    }
    
    public static void cryptage(String sourcePath, String destinationPath) {
        try {
            FileReader fileReader = new FileReader(sourcePath);
            FileWriter fileWriter = new FileWriter(destinationPath);
            
            int character;
            while ((character = fileReader.read()) != -1) {
                char encryptedChar = (char) (character + 1);
                fileWriter.write(encryptedChar);
            }
            
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
