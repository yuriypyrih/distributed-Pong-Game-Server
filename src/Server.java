
import java.net.*;
import java.io.*;
public class Server {
	 public static void main(String[] args) {
		 try{
			 ServerSocket server = new ServerSocket(5000,50);
			 while (true){
				 System.out.println("Accepting Connection...");
				 System.out.println("Local Address :"+server.getInetAddress()+" Port: "+server.getLocalPort());
				 Socket sock = server.accept();
				 ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
				 ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
				
				 MessageObject message = (MessageObject) instream.readObject();
				 if (message.getREQUEST() == REQUEST_TYPE.START){ //following the protocol
					
					 do{
						
						
					 }while(message.getREQUEST() == REQUEST_TYPE.END); //bye = terminate the conversation
				 }
				 else { //not following the protocol
				
				 }
				 instream.close();
				 outstream.close();
				 sock.close();
				 System.out.println("Connection Closing...");
			 }
		}
		 catch (Exception ex){
			 System.out.println("Error during I/O");
			 ex.getMessage();
			 ex.printStackTrace();
		 } 
	 }
 }