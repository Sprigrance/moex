package ru.sprigrance.moex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sprigrance.moex.domain.securities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
