import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/12/12
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class DailyAdviceServer {

    String[] adviceList = {"Do This", "Do That", "Blah! Blah!"};

    public void getAdvice () {

        try {

            ServerSocket sockServ = new ServerSocket (4242);

            while (true) {

                Socket sock = sockServ.accept();

                PrintWriter outputWriter = new PrintWriter (sock.getOutputStream());

                outputWriter.println (adviceList [((int) (Math.random() * 3))]);

                outputWriter.close();
            }
        }

        catch (IOException exOI) {

            exOI.printStackTrace();
        }
    }

    public static void main (String args[]) {

        DailyAdviceServer server = new DailyAdviceServer ();

        server.getAdvice();
    }
}
