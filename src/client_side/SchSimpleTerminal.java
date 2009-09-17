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
			
			BufferedReader sockBR = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			String line = null;
			while((line = br.readLine())!=null){
				bw.write(line+'\n');
				bw.flush();
				
				
				String r = null;
				
				while ((r= sockBR.readLine())!=null){
					System.out.println(r);
					
				}
				
			
				
				
				//while ((r = sockBR.readLine())!=null){
				//	System.out.println(r);
				//}
				//while ((r = new BufferedReader(new InputStreamReader(sock.getInputStream())).readLine()) != null){
				//	System.out.println(r);
				//}
				System.out.println("Got out:)");
				//BufferedReader sockBuff = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				//while (sockBuff.ready()){
				//	System.out.println(sockBuff.readLine());
				//}
				//System.out.println(new BufferedReader(new InputStreamReader(sock.getInputStream())).readLine());
			}
		}catch(IOException ioe){ioe.printStackTrace();}
	}
} 
