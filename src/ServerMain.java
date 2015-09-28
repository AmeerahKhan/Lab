
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

  

    public static void main(String[] args) throws IOException, InterruptedException {

        int number, temp;
        try {

            ServerSocket serverSocket = new ServerSocket(9002);
             InetAddress addr = InetAddress.getLocalHost();
             String hostname = addr.getHostName();
             
            System.out.println("server has been started in the server");
            System.out.println("Server is waiting connection at" + InetAddress.getLocalHost().getCanonicalHostName() + "port" + serverSocket.getLocalPort());
System.out.println("The hostname is "+hostname);
            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Client Connection Accepted");
                
                //pass on handling on this client to a thread
                (new ClientHandler(socket)).start();

            }
        } catch (Exception e) {
            System.err.println("Server already in use");
            System.exit(-1);
        }
    }
}
