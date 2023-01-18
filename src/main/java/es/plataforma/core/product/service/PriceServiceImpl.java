package es.plataforma.core.product.service;

import es.plataforma.core.product.entity.Price;
import es.plataforma.core.product.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAllPrice() {
        return priceRepository.findAll();
    }
}
