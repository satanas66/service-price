package es.plataforma.core.product.repository;

import es.plataforma.core.product.entity.Cadena;
import es.plataforma.core.product.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    List<Price> findByCadena(Cadena cadena);

    @Query(value = "select * from tbl_price where start_date between cast(:startDate AS timestamp) and cast(:endDate AS timestamp) and product_id= :productId and brand_id= :brandId order by priority desc limit 1", nativeQuery = true)
    Price getPriceByApplicationDateProductIdAndCadenaId(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("productId") Integer productId, @Param("brandId") Integer brandId);
}
