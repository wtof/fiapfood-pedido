package br.com.fiapfood.pedido.application.payload.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorResponseTest {

    @Test
    void testStatus() {
        ErrorResponse errorResponse = ErrorResponse.builder().status(404).build();
        int expected = 404;
        assertEquals(expected, errorResponse.getStatus());
    }

    @Test
    void testMessage() {
        ErrorResponse errorResponse = ErrorResponse.builder().message("Not Found").build();
        String expected = "Not Found";
        assertEquals(expected, errorResponse.getMessage());
    }
}