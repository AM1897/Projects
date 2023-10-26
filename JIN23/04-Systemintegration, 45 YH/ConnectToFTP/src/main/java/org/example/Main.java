package org.example;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class Main {
    static String server = "127.0.0.1";
    static int portNr = 21;
    static String userName = "Aram";
    static String password = "1897";
    static String virtualPath = "/upload";
    static String localFilePath = "src/main/resources/data.txt";

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Anropa metoden
        //uploadToFTP();
        fetchFromFTP();
    }

    static void uploadToFTP() {
        // Skapa en FTPClient objekt
        FTPClient ftpClient = new FTPClient();

        try {
            // Establera kopplingen
            ftpClient.connect(server, portNr);
            ftpClient.login(userName, password);

            // Gå till den virtuella sökvägen
            ftpClient.changeWorkingDirectory(virtualPath);

            // Skicka upp .txt filen till FTP servern
            FileInputStream localFile = new FileInputStream(localFilePath);
            ftpClient.storeFile("data.txt", localFile);

            // Stäng kopplingen och logga ut
            localFile.close();
            ftpClient.logout();
            ftpClient.disconnect();

            System.out.println("File uploaded successfully");

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void fetchFromFTP() {
        // Skapa en FTPClient objekt
        FTPClient ftpClient = new FTPClient();

        try {
            // Establera kopplingen
            ftpClient.connect(server, portNr);
            ftpClient.login(userName, password);

            // Gå till den virtuella sökvägen
            ftpClient.changeWorkingDirectory(virtualPath);

            // Hämta .txt filen från FTP servern
            FileOutputStream localFile = new FileOutputStream(localFilePath);
            ftpClient.retrieveFile("data.txt", localFile);

            // Stäng kopplingen och logga ut
            localFile.close();
            ftpClient.logout();
            ftpClient.disconnect();

            System.out.println("Download successfully");

            //Läsa av fil och skriva ut
            File file = new File(localFilePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}