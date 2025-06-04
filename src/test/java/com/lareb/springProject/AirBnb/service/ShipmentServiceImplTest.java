package com.lareb.springProject.AirBnb.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Slf4j
class ShipmentServiceImplTest {

    @Autowired
    private ShipmentService shipmentService;

    @Test
    void testOrderPackage_returnsSuccessMessage() {
        Long orderId = 123L;
        String result = shipmentService.orderPackage(orderId);
        log.info(result);

        assertThat(result).isEqualTo("Order has been processed successfully, orderId: " + orderId);
    }

    @Test
    void testTrackPackage_throwsRuntimeException() {
        Long orderId = -456L;

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            shipmentService.trackPackage(orderId);
        });

        assertThat(exception.getMessage()).isEqualTo("Exception occurred during trackPackage");
    }
}
