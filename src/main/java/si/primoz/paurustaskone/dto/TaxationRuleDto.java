package si.primoz.paurustaskone.dto;

import si.primoz.paurustaskone.model.TaxationRules;
import java.math.BigDecimal;

public record TaxationRuleDto(TaxationRules.TaxationType taxationType, TaxationRules.TaxCalculationType calculationType, BigDecimal taxValue) {

    public boolean isTaxRate() {
        return TaxationRules.TaxCalculationType.RATE.equals(calculationType);
    }
}
