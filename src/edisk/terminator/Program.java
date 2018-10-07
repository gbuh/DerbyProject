package edisk.terminator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/terminator.xml");
        // Quotes quotes = context.getBean(Quoters.class); //TerminateQuoters
        // quotes.sayQuote();
        // ((ClassPathXmlApplicationContext) context).close();
        // ApplicationContext context = new AnnotationConfigApplicationContext(TerminateQuotes.class,
        // InjectParametrIntAnnotationBeanPostProcessor.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Quotes quotes = (Quotes) context.getBean(Quotes.class);
        quotes.sayQuote();
        ((AnnotationConfigApplicationContext) context).close();
    }
}
