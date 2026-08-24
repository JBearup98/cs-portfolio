package com.contact.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private static final String CONTACT_ID = "CT501";
    private static final String FIRST_NAME = "Nina";
    private static final String LAST_NAME = "Cole";
    private static final String PHONE = "5085557319";
    private static final String ADDRESS = "72 Maple Crossing";

    @Test
    public void testAddContact_withUniqueId_contactIsStored() {
        ContactService service = new ContactService();
        Contact contact = createContact();

        service.addContact(contact);

        assertEquals(contact, service.getContact(CONTACT_ID));
    }

    @Test
    public void testAddContact_withDuplicateId_throwsException() {
        ContactService service = new ContactService();
        Contact firstContact = createContact();
        Contact secondContact = new Contact(
                CONTACT_ID,
                "Owen",
                "Grant",
                "4135557741",
                "86 Cedar Point"
        );

        service.addContact(firstContact);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addContact(secondContact)
        );
    }

    @Test
    public void testAddContact_withNullContact_throwsException() {
        ContactService service = new ContactService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.addContact(null)
        );
    }

    @Test
    public void testGetContact_withExistingId_returnsEqualNewInstance() {
        ContactService service = new ContactService();
        Contact contact = createContact();

        service.addContact(contact);

        Contact retrievedContact = service.getContact(CONTACT_ID);

        assertEquals(contact, retrievedContact);
        assertNotSame(contact, retrievedContact);
    }

    @Test
    public void testGetContact_withMissingId_returnsNull() {
        ContactService service = new ContactService();

        assertNull(service.getContact("MISSING"));
    }

    @Test
    public void testDeleteContact_withExistingId_returnsNullAfterDeletion() {
        ContactService service = new ContactService();
        Contact contact = createContact();

        service.addContact(contact);
        service.deleteContact(CONTACT_ID);

        assertNull(service.getContact(CONTACT_ID));
    }

    @Test
    public void testUpdateContact_withExistingId_updatesStoredContact() {
        ContactService service = new ContactService();
        Contact originalContact = createContact();

        Contact expectedContact = new Contact(
                CONTACT_ID,
                "Elena",
                "Parker",
                "7635559021",
                "91 Lakeview Drive"
        );

        service.addContact(originalContact);

        service.updateContact(
                CONTACT_ID,
                "Elena",
                "Parker",
                "7635559021",
                "91 Lakeview Drive"
        );

        assertEquals(expectedContact, service.getContact(CONTACT_ID));
    }

    @Test
    public void testUpdateContact_withMissingId_doesNotCreateContact() {
        ContactService service = new ContactService();

        assertDoesNotThrow(() ->
                service.updateContact(
                        "MISSING",
                        "Elena",
                        "Parker",
                        "7635559021",
                        "91 Lakeview Drive"
                )
        );

        assertNull(service.getContact("MISSING"));
    }

    private Contact createContact() {
        return new Contact(
                CONTACT_ID,
                FIRST_NAME,
                LAST_NAME,
                PHONE,
                ADDRESS
        );
    }
}