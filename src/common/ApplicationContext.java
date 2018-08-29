package common;

public interface ApplicationContext {
    <T> T getBean(Class<T> clazz);
}
