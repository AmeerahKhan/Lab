
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ameerah
 */
public class ServerMain {
    private static int BUFSIZE =1024;

    private StringBuffer result;
    ServerSocket serverSocket;
    String serverText;
    StringBuffer output = new StringBuffer();
    private Object serversocket;

    public String executeCommand(String cmd)
            throws IOException, InterruptedException /*{ class Threadclass implements Runnable{
       
     private String[] cmd ={};
    
     Threadclass(String[] command)
     {System.out.println("The value in thread class is in the server");
     this.cmd=command;
     }*/ {
        try {

            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            System.out.println("Inside the execute method");
            String line = "";
            while ((line = reader.readLine()) != null) {

                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

    public static void main(String[] args) throws IOException, InterruptedException {

        int number, temp;
        try {

            ServerSocket serverSocket = new ServerSocket(9002);
            System.out.println("server has been started in the server");
            System.out.println("Server is waiting connection at" + InetAddress.getLocalHost().getCanonicalHostName() + "port" + serverSocket.getLocalPort());
            
            while(true){
            Socket socket = serverSocket.accept();
            
                  System.out.println("Client Connection Accepted");
            handleClient(socket);
            
            }
            //ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
            //ObjectOutputStream objectServeroutput = new ObjectOutputStream(socket.getOutputStream());
            }
           // objectServeroutput.writeBytes(result);

//objectInput.close();
//objectServeroutput.close();
         catch (Exception e) {
            System.err.println("Server already in use");
            System.exit(-1);
        }

    }
    static void handleClient(Socket socket)throws Exception{
    
    BufferedReader myInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter outWriter = new PrintWriter(socket.getOutputStream());
     System.out.println("before accepting the command in server");
            String inputLine=null;
            ServerMain objectMain = new ServerMain();
            byte[] buff = new byte[BUFSIZE];
		int bytesread = 0;
            //    InputStream in=socket.getInputStream();
              //  OutputStream out=socket.getOutputStream();
		
            while ((inputLine=myInput.readLine())!=null)
                //String command = myInput.readLine();
            {
                System.out.println(inputLine);

            }
                String result = objectMain.executeCommand(inputLine);
                System.out.println(result);
                outWriter.write(result);

           
    }

}
