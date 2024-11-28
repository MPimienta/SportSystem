package app.types.users;

import app.models.lists.elements.Element;
import app.types.commands.Command;
import app.types.Error;

public interface User extends Element {
    UserType getUserType();
    String getUserName();
    String getPassword();
    Command getCommand(String commandName);
    Error getCommandError(Command command);
}
