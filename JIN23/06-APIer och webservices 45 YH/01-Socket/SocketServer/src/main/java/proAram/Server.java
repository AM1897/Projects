package proAram;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private static List<ClientHandler> clients = new ArrayList<>();

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(4321);
			System.out.println("Server startad och väntar på klienter...");

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Ny klient ansluten: " + socket.getInetAddress().getHostAddress());

				ClientHandler clientHandler = new ClientHandler(socket);
				clients.add(clientHandler);
				new Thread(clientHandler).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void broadcastMessage(String message, ClientHandler sender) {
		System.out.println("Sänder meddelande till alla klienter: " + message);
		for (ClientHandler client : clients) {
			if (client != sender) {
				System.out.println("Sänder till: " + client.socket.getInetAddress().getHostAddress());
				client.sendMessage(message);
			}
		}
	}


	private static class ClientHandler implements Runnable {
		private Socket socket;
		private BufferedReader br;
		private BufferedWriter bw;

		public ClientHandler(Socket socket) {
			try {
				this.socket = socket;
				this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				closeEverything(socket, br, bw);
			}
		}

		@Override
		public void run() {
			String message;
			try {
				while ((message = br.readLine()) != null) {
					System.out.println("Mottaget: " + message);
					Server.broadcastMessage("Klient säger: " + message, this);
				}
			} catch (IOException e) {
				closeEverything(socket, br, bw);
			}
		}

		public void sendMessage(String message) {
			try {
				System.out.println("Sänder till klient: " + socket.getInetAddress().getHostAddress() + " Meddelande: " + message);
				bw.write(message);
				bw.newLine();
				bw.flush();
			} catch (IOException e) {
				closeEverything(socket, br, bw);
			}
		}


		public void closeEverything(Socket socket, BufferedReader br, BufferedWriter bw) {
			removeClientHandler();
			try {
				if (bw != null) {
					bw.close();
				}
				if (br != null) {
					br.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void removeClientHandler() {
			clients.remove(this);
			System.out.println("En klient har kopplats från servern.");
		}
	}
}
