import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*This class is application for client to display total words of sentence from server
 * 
 * By ainahazlin
 * 
 */

public class ClientCountWordsApplication {
	public static void main(String[] args) 
			throws UnknownHostException, IOException {

		// Launch client-side frame
		ClientCountWordsFrame clientDateFrame = new ClientCountWordsFrame();
		clientDateFrame.setVisible(true);

		// Connect to the server @ localhost, port 1122
		Socket socket = new Socket(InetAddress.getLocalHost(), 1122);

		// Update the status of the connection
		clientDateFrame.updateConnectionStatus(socket.isConnected());

		// Read from network
		//BufferedReader bufferedReader = new BufferedReader(
			//	new InputStreamReader(socket.getInputStream()));
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());

		// Display the total words
		int totalword = inputStream.read();
		clientDateFrame.updateServerWord(totalword);

		// Close everything
		//bufferedReader.close();
		socket.close();

	}
}
