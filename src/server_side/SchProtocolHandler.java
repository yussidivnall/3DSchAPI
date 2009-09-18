import javax.net.ssl.*;
import java.io.*;

public class SchProtocolHandler {
	SSLSocket socket;
	boolean done = false;
	PrintWriter pout;
	
	SchProtocolHandler(SSLSocket sock){ 
		System.out.println("Protocol handler CONSTRUCTOR");
		socket=sock;
	}
	public void RequestListener(){
		System.out.println("Protocol handler starting...");
		try{
			InputStream is= socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			pout = new PrintWriter(socket.getOutputStream(),true);
			
			String line = null;
			
			pout.println("Welcome client!");
			pout.println("Prepare to be bored!");
			System.out.println("Waiting for client input now...");
			while((line=br.readLine())!=null && !done ){
				System.out.println(line);
				System.out.flush();
				parseLine(line);
			}
			
			is.close();
			//os.close();
		}catch(IOException ioe){ioe.printStackTrace();}
	}
	public void parseLine(String line){
		if(line.equals(new String("GETALL"))){
			dumpAll();
		}else if(line.startsWith("GETJOBS:")){
			dumpJobs(line);
		}else if (line.equals(new String("quit"))){done=true;}
	}
	
	public void dumpAll(){
		System.out.println("Dumping all map");
		try{
			
			pout.println("GAGAGAGAG");
			pout.println("GAGAGAGAG");
			pout.println("GAGAGAGAG");
			//pout.close();
		}catch(Exception ioe){ioe.printStackTrace();}
	}
	public void dumpJobs(String request){
		System.out.println("Dumping requested jobs:"+request);
	}
}
