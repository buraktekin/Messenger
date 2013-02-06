import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public static void main (String[] args) throws UnknownHostException, IOException {
		String client = args[0];
		Socket socket = new Socket("localhost", 4444);
		BufferedReader mclient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
		pw.println(client);
		BufferedReader input= new java.io.BufferedReader(new InputStreamReader(System.in));
		while(true){
			String message=input.readLine();
			pw.println(client +" says: " + message);
			System.out.println(mclient.readLine());
		}
		
	}
}
