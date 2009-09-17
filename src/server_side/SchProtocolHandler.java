import javax.net.ssl.*;
import java.io.*;

public class SchProtocolHandler {
	SSLSocket socket;
	
	
	SchProtocolHandler(SSLSocket sock){ 
		System.out.println("Protocol handler CONSTRUCTOR");
		socket=sock;
	}
	public void RequestListener(){
		System.out.println("Protocol handler starting...");
		try{
			InputStream istream= socket.getInputStream();
			System.out.println("Got Input stream :) ...");
			
			InputStreamReader isr = new InputStreamReader(istream);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			System.out.println("Waiting for client input now...");
			while((line=br.readLine())!=null){
				System.out.println(line);
				System.out.flush();
			}
		}catch(IOException ioe){ioe.printStackTrace();}
	}

}
