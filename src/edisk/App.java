package edisk;

import edisk.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        final ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");

        final HelloService srv = ctx.getBean(HelloService.class);

        // Printer printer = new FilePrinter("out.txt");
        // Printer printer = new StdPrinter();
        // printer.print("Hello!");
        srv.print();

        log.info("{} {}!!!", 555, "Logger");
    }

}
