package ru.job4j.socket;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {
    private static final String LINE = System.getProperty("line.separator");

    @Test
    public void whenAskHelloOracleAndByeThenAnswerHelloTravelerAndByeMyFriend() throws IOException {
        this.testClient(
                String.format("Привет, Оракул.%sПока.%s", LINE, LINE),
                String.format("Здравствуй, путник.%s%sДо встречи, мой друг.%s%s", LINE, LINE, LINE, LINE),
                String.format("Здравствуй, путник.%sДо встречи, мой друг.%s", LINE, LINE)
        );
    }

    @Test
    public void whenAskWhatIsMyNameThenAnswerViktorBugDestroyer() throws IOException {
        this.testClient(
                String.format("Как меня зовут?%sПока.%s", LINE, LINE),
                String.format("Виктор - крушитель багов.%s%sДо встречи, мой друг.%s%s", LINE, LINE, LINE, LINE),
                String.format("Виктор - крушитель багов.%sДо встречи, мой друг.%s", LINE, LINE)
        );
    }

    @Test
    public void whenAskWhatDayIsTodayThenAnswerTodayIsBestDay() throws IOException {
        this.testClient(
                String.format("Какой сегодня день?%sПока.%s", LINE, LINE),
                String.format("Сегодня самый лучший день.%s%sДо встречи, мой друг.%s%s", LINE, LINE, LINE, LINE),
                String.format("Сегодня самый лучший день.%sДо встречи, мой друг.%s", LINE, LINE)
        );
    }

    private void testClient(String ask, String answerln, String answer) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(answerln.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream print = new ByteArrayOutputStream();
        System.setOut(new PrintStream(print));
        System.setIn(new ByteArrayInputStream(ask.getBytes()));
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.run();
        assertThat(out.toString(), is(ask));
        assertThat(print.toString(), is(answer));
    }
}
