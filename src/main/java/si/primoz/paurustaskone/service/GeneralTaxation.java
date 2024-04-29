package si.primoz.paurustaskone.service;

import si.primoz.paurustaskone.dto.Incoming;
import si.primoz.paurustaskone.dto.TaxationRuleDto;
import java.math.BigDecimal;

public class GeneralTaxation implements Taxation {

    public BigDecimal calculateTaxation(Incoming incoming, TaxationRuleDto taxationRuleDto) {

        return switch (taxationRuleDto.calculationType()) {
            case RATE -> incoming.amountBefTax().subtract(incoming.amountBefTax().multiply(taxationRuleDto.taxValue()));
            case AMOUNT -> incoming.amountBefTax().subtract(taxationRuleDto.taxValue());
        };
    }
}
