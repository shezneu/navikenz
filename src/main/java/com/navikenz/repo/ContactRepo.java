package com.navikenz.repo;

import com.navikenz.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{
    public List<com.navikenz.entity.Contact> findContactsByFullname(String fullName);
    public com.navikenz.entity.Contact findContactsById(Long contId);
    public com.navikenz.entity.Contact deleteContactById(Long contId);
}
