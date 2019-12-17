package ru.job4j.socket;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {
    private static final String LINE = System.getProperty("line.separator");

    @Test
    public void whenByeThenGetAnswer() throws IOException {
        String input = "Пока.";
        String expected = String.format("До встречи, мой друг.%s%s", LINE, LINE);
        this.testServer(input, expected);
    }

    @Test
    public void whenHelloThenGetAnswer() throws IOException {
        String input = String.format(
                "Привет, Оракул.%sПока.%s", LINE, LINE);
        String expected = String.format(
                "Здравствуй.%sЧто ты хочешь узнать?%s%sДо встречи, мой друг.%s%s",
                LINE, LINE, LINE, LINE, LINE);
        this.testServer(input, expected);
    }

    @Test
    public void whenSayMyNameThenGetAnswer() throws IOException {
        String input = String.format(
                "Как меня зовут?%sПока.%s", LINE, LINE);
        String expected = String.format(
                "Виктор - крушитель багов.%s%sДо встречи, мой друг.%s%s", LINE, LINE, LINE, LINE);
        this.testServer(input, expected);
    }

    @Test
    public void whenWhatDayIsTodayThenGetAnswer() throws IOException {
        String input = String.format(
                "Какой сегодня день?%sПока.%s", LINE, LINE);
        String expected = String.format(
                "Сегодня самый лучший день.%s%sДо встречи, мой друг.%s%s", LINE, LINE, LINE, LINE);
        this.testServer(input, expected);
    }

    @Test
    public void whenWhatWillIGetNewYearThenGetAnswer() throws IOException {
        String input = String.format(
                "Что я получу на Новый год?%sПока.%s", LINE, LINE);
        String expected = String.format(
                "Ожирение.%s%sДо встречи, мой друг.%s%s", LINE, LINE, LINE, LINE);
        this.testServer(input, expected);
    }

    @Test
    public void whenUnsupportedThenGetAnswer() throws IOException {
        String input = String.format(
                "Я найду себе девушку?%sПока.%s", LINE, LINE);
        String expected = String.format(
                "Да, несомненно.%s%sДо встречи, мой друг.%s%s", LINE, LINE, LINE, LINE);
    this.testServer(input, expected);
    }

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.run();
        assertThat(out.toString(), is(expected));
    }
}
