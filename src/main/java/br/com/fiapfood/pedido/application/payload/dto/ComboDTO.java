package br.com.fiapfood.pedido.application.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComboDTO {

    private Long id;

    private Integer quantidade;
}