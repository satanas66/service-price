package es.plataforma.core.product;

import es.plataforma.core.product.entity.Cadena;
import es.plataforma.core.product.entity.Price;
import es.plataforma.core.product.repository.PriceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class PriceRepositoryMockTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    public void whenFindCadenaThenReturnListPrice(){
        Cadena cadena = Cadena.builder()
                .id(1)
                .name("Zara")
                .build();
        List<Price> founds = priceRepository.findByCadena(cadena);
        Assertions.assertThat(founds.size()).isEqualTo(4);
    }
}
