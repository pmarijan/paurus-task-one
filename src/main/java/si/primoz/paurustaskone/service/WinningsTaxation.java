package si.primoz.paurustaskone.service;

import si.primoz.paurustaskone.dto.Incoming;
import si.primoz.paurustaskone.dto.TaxationRuleDto;

import java.math.BigDecimal;

public class WinningsTaxation implements Taxation {

    @Override
    public BigDecimal calculateTaxation(Incoming incoming, TaxationRuleDto taxationRuleDto) {

        return switch (taxationRuleDto.calculationType()) {
            case RATE -> incoming.winAmount().multiply(taxationRuleDto.taxValue());
            case AMOUNT -> incoming.winAmount().subtract(taxationRuleDto.taxValue());
        };
    }
}
