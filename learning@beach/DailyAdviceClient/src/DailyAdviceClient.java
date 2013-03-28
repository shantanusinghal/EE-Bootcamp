import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/12/12
 * Time: 1:53 PM
 */

public class DailyAdviceClient {

    public void getAdvice () {

        try {

            Socket socket = new Socket ("127.0.0.1", 4242);

            BufferedReader inputReader = new BufferedReader (new InputStreamReader (socket.getInputStream()));

            System.out.println(inputReader.readLine());

            socket.close();
        }

        catch (IOException exIO) {

            System.out.println ("The Server is probably down!..here are more details just-in-case\n");
            exIO.printStackTrace();
        }
    }

    public static void main (String args[]) {

        DailyAdviceClient client = new DailyAdviceClient ();

        client.getAdvice();
    }
}
