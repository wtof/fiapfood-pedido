package br.com.fiapfood.pedido.infra.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfraExceptionTest {

    @Test
    void testDefaultConstructor() {
        InfraException exception = new InfraException();
        assertNull(exception.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        String message = "Test message";
        InfraException exception = new InfraException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String message = "Test message";
        Throwable cause = new RuntimeException("Test cause");
        InfraException exception = new InfraException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Test cause");
        InfraException exception = new InfraException(cause);
        assertEquals(cause, exception.getCause());
    }
}