package tp5_3;
import java.io.*;

public class Authentication {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\fichiers\\in.txt";
        
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        
        String line;
        boolean authenticated = false;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length >= 2) { 
                String login = parts[0];
                String password = parts[1];
                
                if (login.equals(getUserLogin()) && password.equals(getUserPassword())) {
                    authenticated = true;
                    break;
                }
            }
        }
        
        reader.close();
        
        if (authenticated) {
            System.out.println("Authentification réussie.");
        } else {
            System.out.println("Échec de l'authentification.");
        }
    }
    
    public static String getUserLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entrez votre login : ");
        return reader.readLine();
    }
    
    public static String getUserPassword() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Entrez votre mot de passe : ");
        return reader.readLine();
    }
}
