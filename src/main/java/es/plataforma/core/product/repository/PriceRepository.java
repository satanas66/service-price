package es.plataforma.core.product.repository;

import es.plataforma.core.product.entity.Cadena;
import es.plataforma.core.product.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    public List<Price> findByCadena(Cadena cadena);
}
