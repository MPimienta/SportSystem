package app.views.console;

import app.views.Message;
import utils.Console;

public class MessageView {
    void write(Message message) {
        Console.getInstance().write(message.toString());
    }

    void writeln(Message message) {
        Console.getInstance().writeln(message.toString());
    }

}
