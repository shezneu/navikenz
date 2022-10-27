package com.navikenz.api;


import com.navikenz.model.Contact;
import com.navikenz.model.Response;
import com.navikenz.service.ContactsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Documented;
import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/fullstack/v1")
@RequiredArgsConstructor
@Slf4j
//@SecurityRequirement(name = "bearerAuth")
public class Api {
    @Autowired
    ContactsService service;

    private static final String SUCCESSFUL_MESSAGE ="Operation successfully performed";
    Response response = new Response("90000", SUCCESSFUL_MESSAGE, null);

    @PostMapping(value = "/contacts", name = "Add a new contact to the store")
    public ResponseEntity<Response> saveContact(@RequestBody @Validated Contact contactInfo,
                                                              Principal principal)
    {
       /* Optional<QuicktellerUser> user = client.userInfo(principal.getName());
        QuicktellerUser quicktellerUser = user.orElseThrow(
                () -> new NotFoundException(new Object[]{principal.getName()}));
        log.debug(USER_FOUND_FOR_EMAIL_ID, quicktellerUser.getEmail());
        Optional<Consumer> consumerOp = consumers.findByEmail(quicktellerUser.getEmail());
        Consumer consumer = consumerOp.orElseThrow(() -> new NotFoundException(quicktellerUser.getEmail()));
        if (Objects.nonNull(transferBeneficiary.getGroupId())) {
            BeneficiaryGroup beneficiaryGroup = beneficiaryGroups.findById(transferBeneficiary.getGroupId()).
                    orElseThrow(() -> new NotFoundException(new Object[]{transferBeneficiary.getGroupId()}));
            log.debug("beneficiaryGroup found for is ::{}",beneficiaryGroup.getId());
        }*/
       com.navikenz.entity.Contact contactSaved = service.saveContact(contactInfo);
        response.setData(contactSaved);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/contacts")
    public ResponseEntity<Response> updateContacts(@RequestBody @Validated Contact contactInfo, Principal principal)
    {
        com.navikenz.entity.Contact contactUpdated = service.updateContact(contactInfo);
        response.setData(contactUpdated);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/contacts", name = "Get All Contacts")
    public ResponseEntity<Response> getContactsList(Principal principal)
    {
        List<com.navikenz.entity.Contact> contactList = service.getAllContacts();
        response.setData(contactList);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/contacts/findByName", name = "Get Contacts By Full Name")
    public ResponseEntity<Response> getContactsByName(@RequestBody @Validated Contact contactInfo, Principal principal)
    {
        List<com.navikenz.entity.Contact> contactList = service.getContactByName(contactInfo);
        response.setData(contactList);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/contacts/{contactId}", name = "Find Contact By Id")
    public ResponseEntity<Response> getContactsById(@PathVariable("contactId") long contactId, Principal principal)
    {
        com.navikenz.entity.Contact contactInfoById = service.getContactById(contactId);
        response.setData(contactInfoById);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/contacts/{contactId}", name = "Delete Contact By Id")
    public ResponseEntity<Response> deleteContactsById(@PathVariable("contactId") long contactId, Principal principal)
    {
        com.navikenz.entity.Contact deletedContact = service.deleteContactById(contactId);
        response.setData(deletedContact);
        return ResponseEntity.ok(response);
    }
}
