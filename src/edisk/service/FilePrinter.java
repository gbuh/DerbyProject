package edisk.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FilePrinter implements Printer {

    private Writer writer;

    public FilePrinter(String name) {
        super();
        try {
            writer = new FileWriter(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print(String msg) {
        try {
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * @Override public void print(String msg) { File file = new File("out.txt"); try { OutputStream out = new
     * FileOutputStream(file); try { out.write(new byte[] {34, 72, 101, 108, 108, 111, 34}); } catch (IOException e) {
     * e.printStackTrace(); } } catch (FileNotFoundException e) { e.printStackTrace(); } }
     */
}
