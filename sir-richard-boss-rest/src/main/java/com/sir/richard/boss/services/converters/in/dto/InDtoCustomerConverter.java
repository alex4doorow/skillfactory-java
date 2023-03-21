package com.sir.richard.boss.services.converters.in.dto;

import com.sir.richard.boss.model.data.AnyCustomer;
import com.sir.richard.boss.model.data.CompanyCustomer;
import com.sir.richard.boss.model.data.Contact;
import com.sir.richard.boss.model.data.Customer;
import com.sir.richard.boss.model.types.CustomerTypes;
import com.sir.richard.boss.rest.dto.DtoCustomer;
import com.sir.richard.boss.services.converters.IOConverter;
import org.springframework.stereotype.Component;

@Component
public class InDtoCustomerConverter implements IOConverter<DtoCustomer, AnyCustomer> {
    @Override
    public AnyCustomer convertTo(DtoCustomer dtoCustomer) {
        AnyCustomer customer;
        if (dtoCustomer.getType() == CustomerTypes.CUSTOMER) {
            Customer localCustomer = new Customer();
            localCustomer.setId(dtoCustomer.getId());
            localCustomer.setPersonId(dtoCustomer.getPerson().getId());
            localCustomer.setFirstName(dtoCustomer.getPerson().getFirstName());
            localCustomer.setMiddleName(dtoCustomer.getPerson().getMiddleName());
            localCustomer.setLastName(dtoCustomer.getPerson().getLastName());
            localCustomer.setPhoneNumber(dtoCustomer.getPerson().getPhoneNumber());
            localCustomer.setEmail(dtoCustomer.getPerson().getEmail());

            customer = localCustomer;
        } else if (dtoCustomer.getType() == CustomerTypes.COMPANY) {
            CompanyCustomer localCustomer = new CompanyCustomer();
            localCustomer.setInn(dtoCustomer.getCompany().getInn());
            localCustomer.setShortName(dtoCustomer.getCompany().getShortName());
            localCustomer.setLongName(dtoCustomer.getCompany().getLongName());

            dtoCustomer.getCompany().getContacts().forEach(teContact -> {
                Contact contact = new Contact(dtoCustomer.getAddress().getCountry());
                contact.setId(teContact.getId());
                contact.setFirstName(teContact.getFirstName());
                contact.setLastName(teContact.getLastName());
                contact.setMiddleName(teContact.getMiddleName());
                contact.setEmail(teContact.getEmail());
                contact.setPhoneNumber(teContact.getPhoneNumber());
                localCustomer.getContacts().add(contact);
            });
            customer = localCustomer;
        } else {
            // TODO dummy ->
            customer = null;
        }
        customer.setId(dtoCustomer.getId());
        return customer;
    }
}
