package com.contact.contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    private static final String CONTACT_ID = "CT407";
    private static final String FIRST_NAME = "Mara";
    private static final String LAST_NAME = "Voss";
    private static final String PHONE = "6175552843";
    private static final String ADDRESS = "48 Harbor Ridge";

    @Test
    public void testConstructor_withValidValues_createsContact() {
        Contact contact = createContact();

        assertEquals(CONTACT_ID, contact.getContactId());
        assertEquals(FIRST_NAME, contact.getFirstName());
        assertEquals(LAST_NAME, contact.getLastName());
        assertEquals(PHONE, contact.getPhone());
        assertEquals(ADDRESS, contact.getAddress());
    }

    @Test
    public void testConstructor_withNullContactId_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        null,
                        FIRST_NAME,
                        LAST_NAME,
                        PHONE,
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withContactIdOverTenCharacters_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        "CT123456789",
                        FIRST_NAME,
                        LAST_NAME,
                        PHONE,
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withNullFirstName_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        null,
                        LAST_NAME,
                        PHONE,
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withFirstNameOverTenCharacters_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        "Alexandrias",
                        LAST_NAME,
                        PHONE,
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withNullLastName_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        null,
                        PHONE,
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withLastNameOverTenCharacters_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        "Montgomerys",
                        PHONE,
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withNullPhone_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        LAST_NAME,
                        null,
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withPhoneUnderTenDigits_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        LAST_NAME,
                        "617555284",
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withPhoneOverTenDigits_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        LAST_NAME,
                        "61755528431",
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withPhoneContainingLetters_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        LAST_NAME,
                        "61755A2843",
                        ADDRESS
                )
        );
    }

    @Test
    public void testConstructor_withNullAddress_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        LAST_NAME,
                        PHONE,
                        null
                )
        );
    }

    @Test
    public void testConstructor_withAddressOverThirtyCharacters_throwsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Contact(
                        CONTACT_ID,
                        FIRST_NAME,
                        LAST_NAME,
                        PHONE,
                        "12345 Brickstreet Avenue Condo 45B"
                )
        );
    }

    @Test
    public void testSetFirstName_withValidValue_updatesFirstName() {
        Contact contact = createContact();

        contact.setFirstName("Lena");

        assertEquals("Lena", contact.getFirstName());
    }

    @Test
    public void testSetFirstName_withInvalidValue_throwsException() {
        Contact contact = createContact();

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setFirstName("Alexandrias")
        );
    }

    @Test
    public void testSetLastName_withValidValue_updatesLastName() {
        Contact contact = createContact();

        contact.setLastName("Stone");

        assertEquals("Stone", contact.getLastName());
    }

    @Test
    public void testSetLastName_withInvalidValue_throwsException() {
        Contact contact = createContact();

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setLastName("Montgomerys")
        );
    }

    @Test
    public void testSetPhone_withValidValue_updatesPhone() {
        Contact contact = createContact();

        contact.setPhone("5085557319");

        assertEquals("5085557319", contact.getPhone());
    }

    @Test
    public void testSetPhone_withInvalidValue_throwsException() {
        Contact contact = createContact();

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setPhone("50855A7319")
        );
    }

    @Test
    public void testSetAddress_withValidValue_updatesAddress() {
        Contact contact = createContact();

        contact.setAddress("72 Maple Crossing");

        assertEquals("72 Maple Crossing", contact.getAddress());
    }

    @Test
    public void testSetAddress_withInvalidValue_throwsException() {
        Contact contact = createContact();

        assertThrows(
                IllegalArgumentException.class,
                () -> contact.setAddress(
                        "12345 Brickstreet Avenue Condo 45B"
                )
        );
    }

    @Test
    public void testEquals_withSameValues_returnsTrue() {
        Contact firstContact = createContact();
        Contact secondContact = createContact();

        assertEquals(firstContact, secondContact);
        assertEquals(firstContact.hashCode(), secondContact.hashCode());
    }

    @Test
    public void testEquals_withDifferentValues_returnsFalse() {
        Contact firstContact = createContact();
        Contact secondContact = new Contact(
                "CT408",
                FIRST_NAME,
                LAST_NAME,
                PHONE,
                ADDRESS
        );

        assertNotEquals(firstContact, secondContact);
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