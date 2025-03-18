package com.sktelecom.nova.modular.monolith.customer.profile.api;


import java.util.List;
import java.util.UUID;

public interface CustomerProfileService {
    CustomerDto registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
    CustomerDto getCustomerById(UUID customerId);
    List<CustomerDto> findAllCustomers();
}
