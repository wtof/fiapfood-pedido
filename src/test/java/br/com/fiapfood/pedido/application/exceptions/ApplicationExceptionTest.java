package br.com.fiapfood.pedido.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationExceptionTest {

    @Test
    void defaultConstructorShouldNotThrowException() {
        assertDoesNotThrow(() -> new ApplicationException());
    }

    @Test
    void constructorWithMessageShouldNotThrowException() {
        assertDoesNotThrow(() -> new ApplicationException("Test message"));
    }

    @Test
    void constructorWithMessageAndCauseShouldNotThrowException() {
        assertDoesNotThrow(() -> new ApplicationException("Test message", new Throwable()));
    }

    @Test
    void constructorWithCauseShouldNotThrowException() {
        assertDoesNotThrow(() -> new ApplicationException(new Throwable()));
    }

    @Test
    void getMessageShouldReturnCorrectMessage() {
        ApplicationException exception = new ApplicationException("Test message");
        assertEquals("Test message", exception.getMessage());
    }

    @Test
    void getMessageWithCauseShouldReturnCorrectMessage() {
        ApplicationException exception = new ApplicationException("Test message", new Throwable());
        assertEquals("Test message", exception.getMessage());
    }
}