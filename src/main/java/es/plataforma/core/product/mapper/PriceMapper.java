package es.plataforma.core.product.mapper;

import es.plataforma.core.product.dto.ResponsePriceDto;
import es.plataforma.core.product.entity.Price;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class PriceMapper {

    public ResponsePriceDto mapReverse(Price source){
        return mapReverse(source, new ResponsePriceDto());
    }

    public ResponsePriceDto mapReverse(Price source, ResponsePriceDto destination){
        if(Objects.isNull(source)){
            return null;
        }
        if(Objects.isNull(destination)){
            return mapReverse(source);
        }

        return ResponsePriceDto.builder()
                .productId(source.getProductId())
                .cadenaId(source.getCadena().getId())
                .rateToApply(source.getPrice())
                .startDateToApply(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(source.getStartDate()))
                .endDateToApply(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(source.getEndDate()))
                .finalPriceToApply(source.getPrice())
                .build();
    }
}
