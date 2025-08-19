package test.java;

import edu.kit.kastel.command.CommandHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    private CommandHandler commandHandler;

    @BeforeEach
    public void setUp() {
        commandHandler = new CommandHandler();
        commandHandler.handleUserInput();
    }

    @Test
    void testConsoleInput(){
        InputStream originalIn = System.in;
        try {
            String fakeInput = "testCommand";
            System.setIn(new ByteArrayInputStream(fakeInput.getBytes(StandardCharsets.UTF_8)));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            assertEquals(out, "Error, command 'testCommand' not found!\n");
        } finally {
            System.setIn(originalIn);
        }
    }

}
