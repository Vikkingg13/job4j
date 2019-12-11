package ru.job4j.io;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class Chat {

    private StringJoiner joiner = new StringJoiner("\n");
    private boolean working = true;
    private boolean mute = false;
    private Input user;
    private Input bot;

    public Chat(Input user, Input bot) {
        this.user = user;
        this.bot = bot;
    }

    public void start() {
        while (working) {
            accept(user.write());
        }
    }

    private void accept(String text) {
        joiner.add(text);
        switch (text) {
            case "продолжить":
                mute = false;
                break;
            case "стоп":
                mute = true;
                break;
            case "закончить":
                working = false;
                createLog();
                break;
            default:
                if (!mute) {
                    joiner.add(bot.write());
                }
        }
    }

    private void createLog() {
        try (FileWriter writer = new FileWriter("src/main/resources/dialog.log")) {
            writer.write(joiner.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
