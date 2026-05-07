package com.eazybytes.jobportal.contact.controller;

import com.eazybytes.jobportal.contact.service.IcontactService;
import com.eazybytes.jobportal.dto.ContactRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private IcontactService contactService;

    public ContactController(IcontactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMag(@RequestBody ContactRequestDto contactRequestDto) {
        boolean isSaved =  contactService.saveContact(contactRequestDto);
        if (isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request processing failed");
        }
    }
}
