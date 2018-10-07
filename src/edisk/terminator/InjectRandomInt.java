package edisk.terminator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface InjectRandomInt {
    int min();

    int max();
}
