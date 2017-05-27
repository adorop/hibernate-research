package adorop.service.validators;

public interface Validator<T> {
    void validate(T entity);
}
