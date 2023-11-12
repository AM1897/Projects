package proAram;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			socket = new Socket("localhost", 4321);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			final BufferedReader finalBr = br;

			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						String serverMessage;
						while ((serverMessage = finalBr.readLine()) != null) {
							System.out.println("Servern svarar: " + serverMessage);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();

			Scanner scan = new Scanner(System.in);
			System.out.println("Start your chat!");
			while (true) {
				String message = scan.nextLine();
				bw.write(message);
				bw.newLine();
				bw.flush();

				if (message.equalsIgnoreCase("Exit")) break;
				if (message.equalsIgnoreCase("serverExit")) break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (socket != null) socket.close();
				if (br != null) br.close();
				if (bw != null) bw.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
