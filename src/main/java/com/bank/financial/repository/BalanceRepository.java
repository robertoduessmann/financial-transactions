package com.bank.financial.repository;

import com.bank.financial.entity.Balance;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, UUID> {

  Optional<Balance> findByUserId(UUID userId);
}
