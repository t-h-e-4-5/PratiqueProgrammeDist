import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main (String [] args) throws IOException {
        System.out.println("Starting Server...");
        ServerSocket ss = new ServerSocket(1234); // Le server est ecouté sur le port 1234
        Socket s = ss.accept(); // Le server a accepter la connexion
                                // Apres l'etabilisement de la connexion il faut faire des transactions sinon il est boqué
        System.out.println("Connexion of other client");

        // Les envoies
        InputStream is = s.getInputStream(); // Avec ce is on va pouvoir lire les données
        // Les receptions
        OutputStream os = s.getOutputStream();

        int number = is.read(); // Recuperation de lentier
        System.out.println("Requet recive");
        int result = number*2; // on le multiplie

        os.write(result); // On l'envoie
        System.out.println("Requet send");

    }
}
