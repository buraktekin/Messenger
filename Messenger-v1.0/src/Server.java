import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	int PORT=4444;
	public static void main (String [] args) throws IOException {
		new Server().runServer();
	}
	
	public void runServer() throws IOException{
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Messenger Server Ready for Connections");
		while(true){
			Socket socket=server.accept();
			new Sthread(socket).start();
		}
	}

}
