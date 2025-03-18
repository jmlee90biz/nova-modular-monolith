package com.sktelecom.nova.modular.monolith.billing.usage.internal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface UsageRecordRepository extends JpaRepository<UsageRecord, UUID> {
}
