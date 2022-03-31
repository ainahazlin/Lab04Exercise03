import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*This class is application for server to count and display words of sentence to client
 * 
 * By ainahazlin
 * 
 */


public class ServerCountWordsApplication {
public static void main(String[] args) throws IOException {
		
		// Launch the server frame
		ServerCountWordsFrame serverFrame = new ServerCountWordsFrame();
		serverFrame.setVisible(true);
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 1122;
		ServerSocket serverSocket = new ServerSocket(portNo);
		
		CountGenerator countgenerator = new CountGenerator();
		
		// Counter to keep track the number of requested connection
		int totalRequest = 0;
		String sentence = "My Name is Aina Hazlin";
		
		// Server needs to be alive forever
		while (true) {
			
			// Message to indicate server is alive
			serverFrame.updateServerStatus(false);
			
			
			// Accept client request for connection
			Socket clientSocket = serverSocket.accept();
			
			// Calculate total words from sentences
			int totalwords = countgenerator.countTotalWords(sentence);
			
			// Create stream to write data on the network
			DataOutputStream outputStream = 
					new DataOutputStream(clientSocket.getOutputStream());
			
			// Send current total back to the client
			outputStream.writeInt(totalwords);
			
			// Close the socket
			clientSocket.close();
		
			// Update the request status
			serverFrame.updateRequestStatus(
					"Data sent to the client: " + totalwords);
			serverFrame.updateRequestStatus("Accepted connection to from the "
					+ "client. Total request = " + ++totalRequest );
			
		}
	}
}
