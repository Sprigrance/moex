package ru.sprigrance.moex.domain.securities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "stocks")
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticker_id")
    private Ticker ticker;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "last_price", precision = 19, scale = 2, nullable = false) // Указываем точность для DECIMAL
    private BigDecimal lastPrice;

    @Column(name = "showed_name")
    private String showedName;

    @Column(name = "target_percent", nullable = false)
    private Float targetPercent;

    @Column(name = "actual_sum", nullable = false, precision = 16, scale = 2)
    private BigDecimal actualSum;

    @Column(name = "target_sum", nullable = false, precision = 16, scale = 2)
    private BigDecimal targetSum;

    @Column(name = "to_buy_count", nullable = false)
    private Float toBuyCount;

    @Column(name = "to_buy_sum", nullable = false, precision = 16, scale = 2)
    private BigDecimal toBuySum;

    @Column(name = "actual_percent", nullable = false)
    private Float actualPercent;

    @Column(name = "to_buy_count_rounded", nullable = false)
    private Long toBuyCountRounded;

    @Column(name = "to_buy_sum_rounded", nullable = false, precision = 16, scale = 2)
    private BigDecimal toBuySumAfterRounded;

    @Column(name = "securities")
    @CollectionTable(name = "stocks_securities")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images;
}
