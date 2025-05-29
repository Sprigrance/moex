package ru.sprigrance.moex.domain.securities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tickers")
@Getter
@Setter
public class Ticker {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @Column
    private String isin;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "last_price", nullable = false)
    private BigDecimal lastPrice;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticker ticker = (Ticker) o;
        return Objects.equals(getIsin(), ticker.getIsin());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIsin());
    }
}
