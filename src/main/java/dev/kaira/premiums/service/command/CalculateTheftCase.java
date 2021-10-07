package dev.kaira.premiums.service.command;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateTheftCase implements ICalculateCommand{
    private static final BigDecimal COEFFICIENT_THEFT = BigDecimal.valueOf(0.11);
    private static final BigDecimal COEFFICIENT_THEFT_EXT = BigDecimal.valueOf(0.05);

    @Override
    public BigDecimal execute(final BigDecimal sum) {
        BigDecimal total = BigDecimal.ZERO;
        if (sum.intValue() >= 15) {
            total = total.add(sum.multiply(COEFFICIENT_THEFT_EXT));
        } else {
            total = total.add(sum.multiply(COEFFICIENT_THEFT));
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }
}
