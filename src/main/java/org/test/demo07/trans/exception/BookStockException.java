package org.test.demo07.trans.exception;

public class BookStockException extends  RuntimeException {

    public BookStockException() {
    }

    public BookStockException(String message) {
        super(message);
    }
}
