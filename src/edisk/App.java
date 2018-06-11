package edisk;

import edisk.service.FilePrinter;
import edisk.service.Printer;

public class App {

    public static void main(String[] args) {
        Printer printer = new FilePrinter("out.txt");

        printer.print("Hello!");
    }

}
