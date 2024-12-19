package app.models.elements.users;

import app.models.elements.Element;
import app.types.UserType;

import java.io.Serializable;

public interface User extends Element, Serializable {
    UserType getUserType();
    String getUserName();
    String getPassword();
}
