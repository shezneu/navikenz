package com.navikenz.service;

import com.navikenz.model.Contact;
import com.navikenz.repo.ContactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ContactsService {
    @Autowired
    ContactRepo contactRepo;

    // Save Contact Record
    public com.navikenz.entity.Contact saveContact(Contact contactInfo /*,Consumer consumer*/) {
        com.navikenz.entity.Contact contact = com.navikenz.entity.Contact.builder().
                id(Long.valueOf(contactInfo.getId())).
                firstName(contactInfo.getFirstName()).
                lastName(contactInfo.getLastName()).
                fullname(contactInfo.getFullname()).
                email(contactInfo.getEmail()).
                notes(contactInfo.getNotes()).
                phone(contactInfo.getPhone()).
                createdOn(contactInfo.getCreatedOn()).
               // comments(contactInfo.getComments()).
               linkedEntities(contactInfo.getLinkedEntities()).build();
        return contactRepo.save(contact);
    }

    // Update Contact Record
    public com.navikenz.entity.Contact updateContact(Contact contactInfo) {
        com.navikenz.entity.Contact contact = com.navikenz.entity.Contact.builder().
                id(Long.valueOf(contactInfo.getId())).
                firstName(contactInfo.getFirstName()).
                lastName(contactInfo.getLastName()).
                fullname(contactInfo.getFullname()).
                email(contactInfo.getEmail()).
                notes(contactInfo.getNotes()).
                phone(contactInfo.getPhone()).
                createdOn(contactInfo.getCreatedOn()).
                // comments(contactInfo.getComments()).
                linkedEntities(contactInfo.getLinkedEntities()).build();
        return contactRepo.save(contact);
    }

    // Get All Contact Records
    public List<com.navikenz.entity.Contact> getAllContacts() {
        List<com.navikenz.entity.Contact> contactList = new ArrayList<>();
        contactRepo.findAll().forEach(cont -> contactList.add(cont));
        return contactList;
    }

    // Get Contact By Name
    public List<com.navikenz.entity.Contact> getContactByName(Contact contactInfo) {
        List<com.navikenz.entity.Contact> contactList = new ArrayList<>();
        contactRepo.findContactsByFullname(contactInfo.getFullname()).forEach(contact -> {
            contactList.add(contact);
        });
        return contactList;
    }

    // Get Contact By Id
    public com.navikenz.entity.Contact getContactById(Long contId) {
        return contactRepo.findContactsById(contId);
    }

    public com.navikenz.entity.Contact deleteContactById(Long contId) {
        return contactRepo.deleteContactById(contId);
    }




}
