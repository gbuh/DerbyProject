package edisk.terminator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

    public static void main(String[] args) {
        // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("edisk.terminator");
        context.refresh();
        Quotes quotes = (Quotes) context.getBean(Quotes.class);
        quotes.sayQuote();
        ((AnnotationConfigApplicationContext) context).close();
    }
}
