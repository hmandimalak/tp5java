package tp5_1;
import java.io.*;
import static java.lang.System.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        out.println("Répertoire courant : "+System.getProperty("user.dir"));
        File rep = new File(".");
        out.println("Chemin relatif : "+rep.getPath());
        out.println("Chemin absolu : "+rep.getAbsolutePath());

        File[] roots = File.listRoots();
        /*File.listRoot()*/
        for (File root : roots) {	
            out.println("Racine : "+root.getPath());
        }

        File[] subDirs = rep.listFiles(File::isDirectory);
        out.println("Liste des répertoires qui existent dans le répertoire courant:");
        for (File element : subDirs) {
            out.println(element.getName());
        }

        File[] files = rep.listFiles(File::isFile);
        out.println("Liste des fichiers qui existent dans le répertoire courant:");
        for (File element : files) {
            out.print(element.getName()+"\t");
            if (element.getName().length() < 8)
                out.print("\t");
            out.printf("%tc", new Date(element.lastModified()));
            out.printf("\t%10d octets\n", element.length());
        }

        // Affichage des répertoires qui commencent par la lettre 'b'
        out.println("Liste des répertoires qui commencent par la lettre 'b':");
        File[] bDirs = rep.listFiles(new Filtre('b'));
        for (File bDir : bDirs) {
            out.println(bDir.getName());
        }
    }
}

// Filtre pour les répertoires qui commencent par une lettre spécifique
class Filtre implements FilenameFilter {
    private char lettre;

    public Filtre(char lettreDebut) {
        lettre = lettreDebut;
    }

    public boolean accept(File repFiltre, String nom) {
        return nom.startsWith(String.valueOf(lettre));
    }
}
