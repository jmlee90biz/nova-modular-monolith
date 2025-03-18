package com.sktelecom.nova.modular.monolith.customer.profile.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
