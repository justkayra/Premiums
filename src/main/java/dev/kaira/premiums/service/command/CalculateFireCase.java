package dev.kaira.premiums.service.command;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateFireCase implements ICalculateCommand{
    private static final BigDecimal COEFFICIENT_FIRE = BigDecimal.valueOf(0.014);
    private static final BigDecimal COEFFICIENT_FIRE_EXT = BigDecimal.valueOf(0.024);

    @Override
    public BigDecimal execute(final BigDecimal sum) {
        BigDecimal total = BigDecimal.ZERO;
        if (sum.intValue() > 100) {
            total = total.add(sum.multiply(COEFFICIENT_FIRE_EXT));
        } else {
            total = total.add(sum.multiply(COEFFICIENT_FIRE));
        }
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }
}
