import java.io.*;
import java.net.*;

public class ChatterClient {
	public static void main(String [] args) throws Exception {
		Socket serverSocket = new Socket(args[0], SERVER_PORT);

		PrintStream toServer = new PrintStream(serverSocket.getOutputStream(), true);
		BufferedReader fromServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		incoming = fromServer.readLine();
		System.out.println(incoming);
		while (serverSocket.isConnected()){
			incoming = "";
			myReply = "";
			while (!myReply.endsWith("...")){
				System.out.print("Client> ");
				myReply = keyboard.readLine();
				toServer.println(myReply);
			}
			
			while(!incoming.endsWith("...")){
				System.out.println(incoming);
				incoming = fromServer.readLine();
			} 
		}
	}
	static String myReply="", incoming="";
	final static int SERVER_PORT = 3333;
}
