package dev.kaira.premiums.service;

import dev.kaira.premiums.DataProvider;
import dev.kaira.premiums.dto.Policy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicyServiceTest {

    @ParameterizedTest
    @ArgumentsSource(DataProvider.class)
    @DisplayName("test \"calculate\" function")
    void calculate(Policy policy) {
        PolicyService service = new PolicyService();
        service.init();
        BigDecimal result = service.calculate(policy);
        assertEquals(BigDecimal.valueOf(2.28), result);
    }
}
