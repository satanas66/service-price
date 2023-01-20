package es.plataforma.core.product.controller;

import es.plataforma.core.product.dto.RequestPriceDto;
import es.plataforma.core.product.dto.ResponsePriceDto;
import es.plataforma.core.product.entity.Price;
import es.plataforma.core.product.mapper.PriceMapper;
import es.plataforma.core.product.service.PriceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value="/prices", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<List<Price>> listPrice(){
        List<Price> prices = priceService.findAllPrice();
        if(prices.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prices);
    }

    @GetMapping(value="/priority")
    public ResponseEntity<ResponsePriceDto> findPriceWithMainPriority(@RequestParam(name = "applicationDate") String applicationDate ,
                                                        @RequestParam(name = "productId") Integer productId,
                                                        @RequestParam(name = "cadenaId") Integer cadenaId){
        String messages = formatMessages(applicationDate, productId, cadenaId);
        if(StringUtils.isNotBlank(messages)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, messages);
        }
        Price price = priceService.findPriceWithHigherPriority(generateRequestPriceDto(applicationDate, productId, cadenaId));
        if(price == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new PriceMapper().mapReverse(price));
    }

    /**
     * Método que genera un RequestPriceDto dados los siguientes parámetros
     * @param applicationDate
     * @param productId
     * @param cadenaId
     * @return
     */
    private RequestPriceDto generateRequestPriceDto(String applicationDate, Integer productId, Integer cadenaId){
        return RequestPriceDto.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .cadenaId(cadenaId)
                .build();
    }

    /**
     * Método de generación de errores cuando los parámetros no son instanciados
     * @param applicationDate
     * @param productId
     * @param cadenaId
     * @return
     */
    private String formatMessages(String applicationDate, Integer productId, Integer cadenaId){
        String result = "";
        if(StringUtils.isBlank(applicationDate) || StringUtils.isEmpty(applicationDate)){
            result = "La fecha de aplicación no puede estar vacía.";
        }
        if(Objects.isNull(productId)){
            result = result + " El identificador del producto no puede estar vacío.";
        }
        if(Objects.isNull(cadenaId)){
            result = result + " El identificador de la cadena no puede estar vacío.";
        }
        return result;
    }
}
