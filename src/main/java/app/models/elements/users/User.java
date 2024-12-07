package app.models.elements.users;

import app.models.elements.Element;
import app.types.UserType;

public interface User extends Element {
    UserType getUserType();
    String getUserName();
    String getPassword();
}
