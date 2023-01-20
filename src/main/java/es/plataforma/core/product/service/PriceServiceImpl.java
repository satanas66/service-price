package es.plataforma.core.product.service;

import es.plataforma.core.product.dto.RequestPriceDto;
import es.plataforma.core.product.entity.Price;
import es.plataforma.core.product.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAllPrice() {
        return priceRepository.findAll();
    }

    @Override
    public Price findPriceWithHigherPriority(RequestPriceDto requestPriceDto) {
        LocalDateTime startApplicationDate = generateStartApplicationDate(requestPriceDto.getApplicationDate());
        LocalDateTime endApplicationDate = generateEndApplicationDate(requestPriceDto.getApplicationDate());
        return priceRepository.getPriceByApplicationDateProductIdAndCadenaId(startApplicationDate, endApplicationDate, requestPriceDto.getProductId(), requestPriceDto.getCadenaId());
    }

    /**
     * Método para generar la fecha y hora de inicio de un día
     * @param date
     * @return LocalDateTime
     */
    private LocalDateTime generateStartApplicationDate(String date){
        LocalDateTime ldt = converterStringToLocalDateTime(date);
        return LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), 00, 00, 00);
    }

    /**
     * Método para generar la fecha y hora de final de un día
     * @param date
     * @return LocalDateTime
     */
    private LocalDateTime generateEndApplicationDate(String date){
        LocalDateTime ldt = converterStringToLocalDateTime(date);
        return LocalDateTime.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth(), 23, 59, 59);
    }

    /**
     * Método encargado de convertir un String a LocalDateTime
     * @param date
     * @return LocalDateTime
     */
    private LocalDateTime converterStringToLocalDateTime(String date){
        DateTimeFormatter formateador = new DateTimeFormatterBuilder()
                .parseCaseInsensitive().append(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toFormatter();
        return LocalDateTime.parse(date, formateador);
    }
}
