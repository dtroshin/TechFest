import java.io.*;
import java.net.*;

public class ChatterServer {
	public static void main(String [] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		System.err.println("Waiting for a client");
		Socket clientSocket = serverSocket.accept();

		System.out.println("Connection requested from: " + clientSocket.getLocalAddress());

		PrintStream toClient = new PrintStream(clientSocket.getOutputStream(), true);
		BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		toClient.println("Whatcha want?");
		while (clientSocket.isConnected()){
			incoming ="";
			myReply="";
			while(!incoming.endsWith("...")) {
				incoming = fromClient.readLine();
				System.out.println(incoming);
			}
			
			while(!myReply.endsWith("...")){
				System.out.print("Server> ");
				myReply = keyboard.readLine();
				toClient.println(myReply);
			}
		}
	}
	
	final static int SERVER_PORT = 3333;
	static String incoming="", myReply="";
}
