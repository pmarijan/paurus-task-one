package si.primoz.paurustaskone.model;

import jakarta.persistence.*;
import lombok.*;
import si.primoz.paurustaskone.service.GeneralTaxation;
import si.primoz.paurustaskone.service.Taxation;
import si.primoz.paurustaskone.service.WinningsTaxation;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "taxation_rules")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TaxationRules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private long id;

    @ToString.Include
    @Enumerated(EnumType.STRING)
    @Column(name = "taxation_type", nullable = false)
    private TaxationType taxationType;

    @ToString.Include
    @Enumerated(EnumType.STRING)
    @Column(name = "tax_calculation_type", nullable = false)
    private TaxCalculationType taxCalculationType;

    @ToString.Include
    @Column(name = "tax_value", nullable = false, precision = 8, scale = 2)
    private BigDecimal taxValue;

    @Getter
    public enum TaxationType {
        GENERAL(new GeneralTaxation()),
        WINNINGS(new WinningsTaxation());

        TaxationType(Taxation taxation) {
            this.taxation = taxation;
        }

        private final Taxation taxation;
    }


    public enum TaxCalculationType {
        RATE, AMOUNT
    }
}