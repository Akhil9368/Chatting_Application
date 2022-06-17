package com.akhil.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.akhil.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker Worker;
     JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException{
		int PORT =Integer.parseInt(ConfigReader.getValue("PORTNo"));
		socket = new Socket(ConfigReader.getValue("Server_Ip"),PORT);
//		System.out.println("Client Comes....");
//		System.out.println("Enter Your Message");
//		Scanner scanner = new Scanner(System.in);
//		String message=scanner.nextLine();
//	    OutputStream outputStream = socket.getOutputStream();
//	    outputStream.write(message.getBytes());
//	    outputStream.close();
//		socket.close();
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
		readMessage();
		
	}
	public void SendMessage(String message) throws IOException {
		message = message + "\n";
		out.write(message.getBytes());
	}
	public void readMessage() {
		Worker = new ClientWorker(in, textArea);
		Worker.start();
	}
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Client client = new Client();
//	}

}
