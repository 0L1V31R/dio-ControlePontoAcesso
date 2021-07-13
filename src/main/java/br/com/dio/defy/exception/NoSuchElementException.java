package br.com.dio.defy.exception;

public class NoSuchElementException extends Exception {
    public NoSuchElementException(long id) {
        super("Element not found with id: " + id);
    }
}
