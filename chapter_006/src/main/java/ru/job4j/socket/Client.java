package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            String ask;
            do {
                ask = console.nextLine();
                out.println(ask);
                for (String str = in.readLine(); !str.isEmpty(); str = in.readLine()) {
                    System.out.println(str);
                }
            } while (!"Пока.".equals(ask));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 4242)) {
            new Client(socket).run();
        }
    }
}