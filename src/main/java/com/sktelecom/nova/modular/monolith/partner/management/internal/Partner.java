package com.sktelecom.nova.modular.monolith.partner.management.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "partner", schema = "partner")
class Partner {
    @Id
    private UUID id;

    private String name;
    private String email;

    public Partner(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    static Partner createPartner(String name, String email) {
        return new Partner(name, email);
    }

    PartnerRegisteredEvent createPartnerRegistereddEvent() {
        return new PartnerRegisteredEvent(id, name, email);
    }
}