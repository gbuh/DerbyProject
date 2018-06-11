package edisk.service;

public class StdPrinter implements Printer {

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

}
