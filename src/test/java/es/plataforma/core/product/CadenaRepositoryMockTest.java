package es.plataforma.core.product;

import es.plataforma.core.product.entity.Cadena;
import es.plataforma.core.product.repository.CadenaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CadenaRepositoryMockTest {

    @Autowired
    private CadenaRepository cadenaRepository;

    @Test
    public void whenFindCadenaThenReturnListPrice(){
        List<Cadena> founds = cadenaRepository.findAll();
        Assertions.assertThat(founds.size()).isEqualTo(1);
    }
}
