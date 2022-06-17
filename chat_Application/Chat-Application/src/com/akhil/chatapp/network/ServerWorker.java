package com.akhil.chatapp.network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.akhil.chatapp.views.override;

public class ServerWorker extends Thread{
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		this.server = server;
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream();
		out = clientSocket.getOutputStream();
		System.out.println("New Client Comes.....");
	}
	@override
	public void  run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String Line;
		try {
			while(true) {
				Line = br.readLine();
				System.out.println("Line Read....."+ Line);
				if(Line.equalsIgnoreCase("quit")) {
					break;
				}
				//out.write(Line.getBytes());
				for(ServerWorker serverWorker : server.workers) {
					Line = Line + "\n";
					serverWorker.out.write(Line.getBytes());
				}
				
			}
		}
			catch(IOException e){
				e.printStackTrace();
				
			}
		finally {
			try {
			    if(br != null) {
				br.close();
			}
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
			if(clientSocket != null) {
				clientSocket.close();
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
