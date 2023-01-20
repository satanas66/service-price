package es.plataforma.core.product.controller;

import es.plataforma.core.product.dto.ResponsePriceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PriceControllerTest {

    private ResponseEntity<ResponsePriceDto> response;

    private String applicationDate;

    private static final Integer productId = 35455;

    private static final Integer cadenaId = 1;

    @Autowired
    private PriceController priceController;

    @Test
    void test1() {
        applicationDate = "2020-06-14 10:00:00";
        response = priceController.findPriceWithMainPriority(applicationDate, productId, cadenaId);

        assertThat((response.getStatusCode()).value()).isEqualTo(200);
        assertThat(response.getBody().getRateToApply()).isEqualTo(25.45);
        assertThat(response.getBody().getStartDateToApply()).isEqualTo("2020-06-14 15:00:00");
        assertThat(response.getBody().getEndDateToApply()).isEqualTo("2020-06-14 18:30:00");
        assertThat(response.getBody().getFinalPriceToApply()).isEqualTo(25.45);
    }

    @Test
    void test2() {
        applicationDate = "2020-06-14 16:00:00";
        response = priceController.findPriceWithMainPriority(applicationDate, productId, cadenaId);

        assertThat((response.getStatusCode()).value()).isEqualTo(200);
        assertThat(response.getBody().getRateToApply()).isEqualTo(25.45);
        assertThat(response.getBody().getStartDateToApply()).isEqualTo("2020-06-14 15:00:00");
        assertThat(response.getBody().getEndDateToApply()).isEqualTo("2020-06-14 18:30:00");
        assertThat(response.getBody().getFinalPriceToApply()).isEqualTo(25.45);
    }

    @Test
    void test3() {
        applicationDate = "2020-06-14 21:00:00";
        response = priceController.findPriceWithMainPriority(applicationDate, productId, cadenaId);

        assertThat((response.getStatusCode()).value()).isEqualTo(200);
        assertThat(response.getBody().getRateToApply()).isEqualTo(25.45);
        assertThat(response.getBody().getStartDateToApply()).isEqualTo("2020-06-14 15:00:00");
        assertThat(response.getBody().getEndDateToApply()).isEqualTo("2020-06-14 18:30:00");
        assertThat(response.getBody().getFinalPriceToApply()).isEqualTo(25.45);
    }

    @Test
    void test4() {
        applicationDate = "2020-06-15 10:00:00";
        response = priceController.findPriceWithMainPriority(applicationDate, productId, cadenaId);

        assertThat((response.getStatusCode()).value()).isEqualTo(200);
        assertThat(response.getBody().getRateToApply()).isEqualTo(30.5);
        assertThat(response.getBody().getStartDateToApply()).isEqualTo("2020-06-15 00:00:00");
        assertThat(response.getBody().getEndDateToApply()).isEqualTo("2020-06-15 11:00:00");
        assertThat(response.getBody().getFinalPriceToApply()).isEqualTo(30.5);
    }

    @Test
    void test5() {
        applicationDate = "2020-06-16 21:00:00";
        response = priceController.findPriceWithMainPriority(applicationDate, productId, cadenaId);
        assertThat((response.getStatusCode()).value()).isEqualTo(204);
        assertThat(response.getStatusCode().name()).isEqualTo("NO_CONTENT");
    }
}