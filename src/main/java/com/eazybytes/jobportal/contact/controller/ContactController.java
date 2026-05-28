package com.eazybytes.jobportal.contact.controller;

import com.eazybytes.jobportal.contact.service.IcontactService;
import com.eazybytes.jobportal.dto.ContactRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private IcontactService contactService;

    public ContactController(IcontactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(path = "/public", version = "1.0")
    public ResponseEntity<String> saveContactMag(@RequestBody @Valid ContactRequestDto contactRequestDto) {
        boolean isSaved =  contactService.saveContact(contactRequestDto);
        if (isSaved) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request processing failed");
        }
    }

    @GetMapping
    public ResponseEntity<String> fetchOpenContacts(@RequestParam @Validated @NotBlank(message = "Status cannot be blank") String status) {
        return ResponseEntity.ok("These are the open contacts");
    }


}
