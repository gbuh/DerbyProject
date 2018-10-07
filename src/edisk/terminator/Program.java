package edisk.terminator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

    public static void main(String[] args) {
        // Quotes quotes = new TerminateQuoters();
        // quotes.sayQuote("I'll be back...");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/terminator.xml");
        Quotes quotes = context.getBean(TerminateQuoters.class);
        quotes.sayQuote();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
