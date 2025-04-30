package com.pranay.StudentSelfReflection.repository;

import com.pranay.StudentSelfReflection.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * File Name: AddressRepositrory.java
 * Entity: AddressRepositrory
 * Package: com.pranay.StudentSelfReflection.repository
 * Author: pranayramteke
 * Date: 01/05/25
 * Description:
 */

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>
{

}
