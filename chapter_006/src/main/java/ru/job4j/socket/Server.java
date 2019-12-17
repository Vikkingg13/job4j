package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {
    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private Map<String, String> answer;
    private static final String LINE = System.getProperty("line.separator");

    public Server(Socket socket) {
        this.socket = socket;
        answer = Map.of(
                "Привет, Оракул.", String.format("Здравствуй.%sЧто ты хочешь узнать?%s", LINE, LINE),
                "Как меня зовут?", String.format("Виктор - крушитель багов.%s", LINE),
                "Какой сегодня день?", String.format("Сегодня самый лучший день.%s", LINE),
                "Что я получу на Новый год?", String.format("Ожирение.%s", LINE),
                "Пока.", String.format("До встречи, мой друг.%s", LINE)
        );
    }

    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ask;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if (answer.containsKey(ask)) {
                    out.println(answer.get(ask));
                } else {
                    out.println(String.format("Да, несомненно.%s", LINE));
                }
            } while (!("Пока.".equals(ask)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket =  new ServerSocket(4242).accept()) {
            new Server(socket).run();
        }
    }
}
