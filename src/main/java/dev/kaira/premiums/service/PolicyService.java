package dev.kaira.premiums.service;

import dev.kaira.premiums.dto.Policy;
import dev.kaira.premiums.dto.PolicyObject;
import dev.kaira.premiums.dto.RiskType;
import dev.kaira.premiums.dto.SubObject;
import dev.kaira.premiums.service.command.CalculateFireCase;
import dev.kaira.premiums.service.command.CalculateTheftCase;
import dev.kaira.premiums.service.command.ICalculateCommand;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;
import java.util.EnumMap;

import static dev.kaira.premiums.dto.RiskType.FIRE;
import static dev.kaira.premiums.dto.RiskType.THEFT;

@ApplicationScoped
public class PolicyService {
    private static final EnumMap<RiskType, ICalculateCommand> riskTypes = new EnumMap(RiskType.class);

    @PostConstruct
    public void init() {
        riskTypes.put(FIRE, new CalculateFireCase());
        riskTypes.put(THEFT, new CalculateTheftCase());
    }

    public BigDecimal calculate(Policy policy) {
        BigDecimal total = BigDecimal.ZERO;
        for (PolicyObject object : policy.getPolicyObjects()) {
            for (SubObject subObject : object.getSubObjects()) {
                total = total.add(riskTypes.get(subObject.getRiskType()).execute(subObject.getSum()));
            }
        }
        return  total ;
    }
}
