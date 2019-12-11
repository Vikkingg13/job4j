package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ChatTest {

    @Test
    public void whenExitFromChatThenCreateLogWithDialog() {
        Stub userInput = new Stub(new String[]
                {"Давай поздравим ментора.", "стоп", "Ой.", "продолжить", "Поздравляй.", "закончить"}
        );
        Stub botInput = new Stub(new String[]
                {"Давай.", "С наступающим тебя, ментор)", "Это не будет выведено"}
        );
        new Chat(userInput, botInput).start();
        StringJoiner result  = new StringJoiner("\n");
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/dialog.log"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String expected =
                "Давай поздравим ментора.\nДавай.\nстоп\nОй.\nпродолжить\nПоздравляй.\nС наступающим тебя, ментор)\nзакончить";
        assertThat(result.toString(), is(expected));
    }
}
