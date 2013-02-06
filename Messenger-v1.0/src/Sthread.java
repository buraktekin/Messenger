import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Sthread extends Thread{
	Socket socket;
	
	Sthread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket=socket;
	}
	
	public void run(){
		try{
			String message=null;
			PrintWriter PW = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(bf.readLine()+ " is connected.");
			while((message=bf.readLine()) != null) {
				System.out.println(message);
				PW.println(message);
			}
			socket.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
