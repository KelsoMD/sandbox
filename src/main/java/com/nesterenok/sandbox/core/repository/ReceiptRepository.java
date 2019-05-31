package com.nesterenok.sandbox.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.nesterenok.sandbox.core.entity.Receipt;

@Component
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
