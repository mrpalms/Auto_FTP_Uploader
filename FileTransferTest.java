import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.text.*;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FileTransferTest{
	
public static void main(String []args){
        
	//ftp server to connect to
	 String ftpServer = ; 
	 
	 // ftp port number default is port 21, sftp for port 22
	 int port = ; 
	 
	 //ftp username
	 String username = ;

	//ftp password
	 String password = ; 
	 
	 //get Today's date
	 Date date = new Date();
	 
	 //format date into date.month.year
	 SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
	 
	 //opens FTP 
	 FTPClient ftpCL = new FTPClient();
	 try {
		 ftpCL.connect(ftpServer, port);
		 boolean success = ftpCL.login(username, password);
		 
		 //return a code during upload
		 int replyCode = ftpCL.getReplyCode();
		 ftpCL.enterLocalPassiveMode();
		 
		 ftpCL.setFileType(FTP.BINARY_FILE_TYPE);
		 
		 //location of folder for the files that will be uploaded
		 File LocalFile = new File(); 
		
		//name of the file when uploaded in the server
		String RemoteFile =; 
		//String FileDate = ft.format(date); //returns current date
		//RemoteFile = RemoteFile.concat(FileDate + ".txt"); // add a date to the end of yje filename and changes it to .txt
		InputStream inputStream = new FileInputStream(LocalFile);
		
		
		//if the upload fails returns a c replyCode
		if (!success){
			 System.out.println("Login Failed " + replyCode);
			 
			 ftpCL.logout();
			 ftpCL.disconnect();
		 }//if end
		 else
		 {
			 System.out.println("Login Success " + replyCode);
			 System.out.println("Start uploading file");
			 
			 //function for sending the file to ftp server.
			 boolean done = ftpCL.storeFile(RemoteFile, inputStream); 
			 
			 //returns a message when the upload is successful
			 if (done){
				 System.out.println("uploaded success");
				 inputStream.close();
				 ftpCL.logout();
				 ftpCL.disconnect();
			 }
			 
			
		 }//else end
			 
		 
		 
	 }catch (IOException e){
		 System.out.println("OOPS something went wrong");
		 e.printStackTrace();
	 }finally{
		 try{
			 if (ftpCL.isConnected()){
				 ftpCL.logout();
				 ftpCL.disconnect();
			 }///
			 
		 }catch (IOException ea){ea.printStackTrace();}
		 
	 }//finally end
	 
	 
	 
	 }//end
}//