package br.com.fiapfood.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class FiapfoodPedidoApplication {
    public FiapfoodPedidoApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(FiapfoodPedidoApplication.class, args);
    }
}
