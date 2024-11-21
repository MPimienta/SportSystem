package app.views;

public enum Message {
    INPUT_COMMAND(">>>");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
