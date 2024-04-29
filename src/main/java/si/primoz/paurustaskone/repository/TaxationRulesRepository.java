package si.primoz.paurustaskone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import si.primoz.paurustaskone.dto.TaxationRuleDto;
import si.primoz.paurustaskone.model.TaxationRules;

import java.util.Optional;

@Repository
public interface TaxationRulesRepository extends JpaRepository<TaxationRules, Long> {

    @Query("""
        SELECT new si.primoz.paurustaskone.dto.TaxationRuleDto(
            rule.taxationType,
            rule.taxCalculationType,
            rule.taxValue
        )
        FROM Trader t
        LEFT JOIN t.location loc
        LEFT JOIN loc.taxationRules rule
        WHERE t.id = :traderId
    """)
    Optional<TaxationRuleDto> findTaxationRuleByTraderId(Long traderId);
}
