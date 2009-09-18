import javax.net.ssl.*;
import java.io.*;
public class SchSimpleTerminal{
	
	public static void main(String[] args){
		try{
			SSLSocketFactory fact = (SSLSocketFactory)SSLSocketFactory.getDefault();
			SSLSocket sock = (SSLSocket)fact.createSocket("localhost",999);

			PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			
			ResponseThread respThread = new ResponseThread(in);
			respThread.start();
			System.out.println("Released, thread is not holding me!");
			
			String command;
			while((command=userInput.readLine())!=null){
				out.println(command);
			}
		}catch(Exception ioe){
			ioe.printStackTrace();
		} finally {}
	}
}

class ResponseThread extends Thread{
	BufferedReader in;
	
	ResponseThread(BufferedReader inp){
		in = inp;
	}
	public void run(){
		String fromServ;
		try{
			while ((fromServ=in.readLine())!=null){
				System.out.println(fromServ);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
} //class ResponseThread

