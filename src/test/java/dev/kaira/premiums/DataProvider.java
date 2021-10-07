package dev.kaira.premiums;

import dev.kaira.premiums.dto.Policy;
import dev.kaira.premiums.dto.PolicyObject;
import dev.kaira.premiums.dto.RiskType;
import dev.kaira.premiums.dto.SubObject;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public class DataProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Policy policy = new Policy();
        PolicyObject policyObject = new PolicyObject();
        SubObject subObject1 = new SubObject();
        subObject1.setRiskType(RiskType.FIRE);
        subObject1.setSum(BigDecimal.valueOf(100));
        SubObject subObject2 = new SubObject();
        subObject2.setRiskType(RiskType.THEFT);
        subObject2.setSum(BigDecimal.valueOf(8));
        policyObject.setSubObjects(List.of(subObject1, subObject2));
        policy.setPolicyObjects(List.of(policyObject));
        return Stream.of(
                Arguments.of(policy)
        );
    }
}
