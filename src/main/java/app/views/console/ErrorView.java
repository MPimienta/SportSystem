package app.views.console;

import app.types.Error;
import utils.Console;

public class ErrorView extends app.views.ErrorView {

    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(app.views.ErrorView.MESSAGES[error.ordinal()]);
        }
    }
}
