import javax.net.ssl.*;
import java.io.*;
public class SchSimpleTerminal{

	public static void main(String[] args){
		try{
			SSLSocketFactory fact = (SSLSocketFactory)SSLSocketFactory.getDefault();
			SSLSocket sock = (SSLSocket)fact.createSocket("localhost",999);
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream os = sock.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String line = null;
			while((line = br.readLine())!=null){
				bw.write(line+'\n');
				bw.flush();
			}
		}catch(IOException ioe){ioe.printStackTrace();}
	}
} 
