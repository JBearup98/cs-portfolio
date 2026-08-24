package com.contact.contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }

        contacts.put(contact.getContactId(), contact);
    }

    public Contact getContact(String contactId) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            return null;
        }

        return new Contact(
                contact.getContactId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhone(),
                contact.getAddress()
        );
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName,
                              String lastName, String phone,
                              String address) {

        Contact contact = contacts.get(contactId);

        if (contact != null) {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setPhone(phone);
            contact.setAddress(address);
        }
    }
}