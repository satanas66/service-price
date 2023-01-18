package es.plataforma.core.product.controller;

import es.plataforma.core.product.entity.Price;
import es.plataforma.core.product.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/prices")
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

}
