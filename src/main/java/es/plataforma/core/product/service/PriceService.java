package es.plataforma.core.product.service;

import es.plataforma.core.product.dto.RequestPriceDto;
import es.plataforma.core.product.entity.Price;

import java.util.List;

public interface PriceService {

    List<Price> findAllPrice();

    Price findPriceWithHigherPriority(RequestPriceDto requestPriceDto);
}
