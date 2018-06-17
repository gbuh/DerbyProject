package edisk;

import edisk.service.Printer;
import org.apache.log4j.Logger;
//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

//    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final Logger log = Logger.getRootLogger();
    private static final Logger logger = Logger.getLogger("edisk");

    public static void main(String[] args) {

        final ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");

//        final HelloService srv = ctx.getBean(HelloService.class);
        final Printer srv = ctx.getBean(Printer.class);

        // Printer printer = new FilePrinter("out.txt");
        // Printer printer = new StdPrinter();
        // printer.print("Hello!");
        srv.print("Hello!!!");

//        log.info("{} {}!!!", 555, "Logger");
        
//        BasicConfigurator.configure();
        log.log(Level.INFO, "Log");
        logger.log(Level.DEBUG, "Logger");

        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
