package es.plataforma.core.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestPriceDto implements Serializable {

    private Integer productId;

    private Integer cadenaId;

    private String applicationDate;
}
