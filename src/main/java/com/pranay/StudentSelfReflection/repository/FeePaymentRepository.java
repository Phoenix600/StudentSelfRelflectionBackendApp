package com.pranay.StudentSelfReflection.repository;

import com.pranay.StudentSelfReflection.model.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeePaymentRepository extends JpaRepository<FeePayment,Long>
{

}
