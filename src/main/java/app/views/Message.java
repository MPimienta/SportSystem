package app.views;

public enum Message {
    INPUT_COMMAND(">>>"),
    LIST_OF_PLAYERS("----List of players----");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
