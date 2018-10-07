package edisk.terminator;

public class TerminateQuotes implements Quotes {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    public TerminateQuotes() {
        super();
        this.message = "Hello!";
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("Message: " + message);
        }
    }
}
