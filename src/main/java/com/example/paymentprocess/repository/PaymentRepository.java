package com.example.paymentprocess.repository;

import com.example.paymentprocess.model.PaymentsModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<PaymentsModel, Long> {
}
