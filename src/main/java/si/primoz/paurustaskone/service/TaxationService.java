package si.primoz.paurustaskone.service;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import si.primoz.paurustaskone.dto.Incoming;
import si.primoz.paurustaskone.dto.Outgoing;
import si.primoz.paurustaskone.repository.TaxationRulesRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TaxationService {

    private final TaxationRulesRepository taxationRulesRepository;

    public Outgoing calculateTaxation(Incoming incoming) {
        Assert.notNull(incoming, "Given 'incoming' object must not be null");

        val taxationRule = taxationRulesRepository.findTaxationRuleByTraderId(incoming.traderId())
                .orElseThrow(() -> new NoSuchElementException("Trader not found"));

        //TODO: what is the difference between possibleReturnAmount and possibleReturnAmountAfterTax?
        val possibleReturnAmount = taxationRule.taxationType().getTaxation().calculateTaxation(incoming, taxationRule);

        val taxRate = taxationRule.isTaxRate() ? taxationRule.taxValue() : null;
        val taxAmount = taxationRule.isTaxRate() ? null : taxationRule.taxValue();

        return new Outgoing(possibleReturnAmount, incoming.amountBefTax(), possibleReturnAmount, taxRate, taxAmount);
    }
}
