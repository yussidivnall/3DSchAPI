import java.net.*;
import javax.net.*;
import javax.net.ssl.*;

public class SchConnectionThread extends Thread{
	SSLSocket socket;
	SchConnectionThread(SSLSocket sock){
		socket=sock;
	}
	
	public void run() {
		//TODO: add login / authentication code
		try{
			System.out.println("Connection thread starting...");
			SchProtocolHandler proto = new SchProtocolHandler(socket);
			proto.RequestListener();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
