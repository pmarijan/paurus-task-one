package si.primoz.paurustaskone.service;

import si.primoz.paurustaskone.dto.Incoming;
import si.primoz.paurustaskone.dto.TaxationRuleDto;

import java.math.BigDecimal;

public interface Taxation {
    BigDecimal calculateTaxation(Incoming incoming, TaxationRuleDto taxationRuleDto);
}
