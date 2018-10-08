package edisk.terminator;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="edisk.terminator")
public class AppConfig {

    @Bean
    public Quotes quotes() {
        TerminateQuotes terminateQuotes = new TerminateQuotes();
        terminateQuotes.setMessage("I'll be back...");
        return terminateQuotes;
    }

    @Bean
    public BeanPostProcessor beanPostprocessor() {
        return new InjectParametrIntAnnotationBeanPostProcessor();
    }
}
