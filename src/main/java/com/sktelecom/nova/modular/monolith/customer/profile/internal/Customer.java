package com.sktelecom.nova.modular.monolith.customer.profile.internal;

import com.sktelecom.nova.modular.monolith.customer.profile.event.CustomerRegisteredEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "customer", schema = "customer")
class Customer {
    @Id
    private UUID id;

    private String name;
    private String email;

    public Customer(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    static Customer createCustomer(String name, String email) {
        return new Customer(name, email);
    }

    CustomerRegisteredEvent createCustomerRegisteredEvent() {
        return new CustomerRegisteredEvent(this.getId(), this.getName(), this.getEmail());
    }

}