package com.akhil.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.akhil.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serversocket;
	Socket ClientSocket;
	ArrayList<ServerWorker> workers= new ArrayList<>();
	public Server() throws IOException {
		int PORT =Integer.parseInt(ConfigReader.getValue("PORTNo"));
		serversocket = new ServerSocket(PORT);
		System.out.println("Server Start and Waiting for the client to Join ....");
		handleClientRequest();
		
		
	}
	public void handleClientRequest() throws IOException {
		while(true) {
			ClientSocket = serversocket.accept();
			//per client per thread
			ServerWorker  serverWorker = new ServerWorker(ClientSocket ,this);
			workers.add(serverWorker);
			serverWorker.start();
			}
	}
//	public Server() throws IOException {
//		
//		System.out.println("Server Started and Waiting for client Connection....");
//		Socket socket = serversocket.accept();
//		System.out.println("Client Joins the server....");
//		InputStream inputStream  = socket.getInputStream();
//		byte [] arr = inputStream.readAllBytes();
//		String str = new String(arr);
//		System.out.println("Received "+ str);
//		socket.close();
//	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
	Server server = new Server();

	}

}
