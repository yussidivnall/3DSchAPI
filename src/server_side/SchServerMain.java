//create ssl connection.
// handle client connections
//		handle requests: getmap,getjob
//		dispatch to clients:job status changed, job failed
//

import java.io.IOException;
import java.net.ServerSocket;
import javax.net.*;
import javax.net.ssl.*;
import java.net.*
;
public class SchServerMain {
	int PORT=999;
	boolean done = false;
	SSLServerSocketFactory fact;
	SSLServerSocket serverSocket;
	SSLSocket socket;
	
	/**
	 * @param args
	 */
	SchServerMain() throws IOException{
		fact = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
		serverSocket=(SSLServerSocket)fact.createServerSocket(PORT);
		System.out.println("Listening");
		listen();
	}
	
	private void listen() throws IOException{
		while (!done){
			System.out.println("Waiting for new client...");
			socket = (SSLSocket) serverSocket.accept();
			System.out.println("client:"+socket.getInetAddress()+" is connected");
			SchConnectionThread connThread = new SchConnectionThread((SSLSocket)socket);
			connThread.start();
			System.out.println("New client accepted:");
		}
	}
	
	
	public static void main(String[] args) {
		try{
			System.out.println("starting...");
			SchServerMain me = new SchServerMain();
		}
		catch (IOException ioe){ioe.printStackTrace();}
		catch (Exception e){e.printStackTrace();}
	}

}
