package dev.kaira.premiums.service.command;

import java.math.BigDecimal;

public interface ICalculateCommand {
    BigDecimal execute(BigDecimal sum);
}
