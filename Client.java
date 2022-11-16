import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main (String [] args) throws IOException {
        System.out.println("Send requet to Server...");
       // ServerSocket ss = new ServerSocket(1234); // Le server est ecouté sur le port 1234
        Socket s = new Socket(InetAddress.getLocalHost(),1234); // Le server a accepter la connexion

        // Apres l'etabilisement de la connexion il faut faire des transactions sinon il est boqué
        System.out.println("Connexion of other client");

        // Les envoies
        InputStream is = s.getInputStream(); // Avec ce is on va pouvoir lire les données
        // Les receptions
        OutputStream os = s.getOutputStream();
        System.out.println("Enter a number : ");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt(); // Recuperation de lentier
        System.out.println("Requet recive");
        //int result = number*2; // on le multiplie

        os.write(number); // On l'envoie
        int nbrReceived = is.read(); ;
        System.out.println("The result send of server is  "+nbrReceived);
        s.close();

    }
}
