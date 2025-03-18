package com.sktelecom.nova.modular.monolith.customer.profile.internal;

import com.sktelecom.nova.modular.monolith.customer.profile.api.CustomerRegistrationRequest;
import com.sktelecom.nova.modular.monolith.customer.profile.api.CustomerDto;
import com.sktelecom.nova.modular.monolith.customer.profile.api.CustomerProfileService;

import com.sktelecom.nova.modular.monolith.shared.kernel.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class CustomerProfileServiceImpl implements CustomerProfileService {
    private final CustomerRepository customerRepository;
    private final EventPublisher eventPublisher;

    @Override
    @Transactional
    public CustomerDto registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer registeredCustomer = customerRepository.save(
                Customer.createCustomer(customerRegistrationRequest.name(), customerRegistrationRequest.email())
        );

        eventPublisher.publish(registeredCustomer.createCustomerRegisteredEvent());

//        if(true) {
//            throw new RuntimeException("TRANSACTION TEST");
//        }
        return CustomerMapper.toCustomerDto(registeredCustomer);
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).map(CustomerMapper::toCustomerDto)
                .orElseThrow(()->new RuntimeException("Customer not found"));
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::toCustomerDto).toList();
    }
}
