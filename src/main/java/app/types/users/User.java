package app.types.users;

import app.models.lists.elements.Element;

public interface User extends Element {
    UserType getUserType();
    String getUserName();
    String getPassword();
}
