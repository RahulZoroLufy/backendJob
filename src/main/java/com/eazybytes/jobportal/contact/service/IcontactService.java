package com.eazybytes.jobportal.contact.service;

import com.eazybytes.jobportal.dto.ContactRequestDto;
import com.eazybytes.jobportal.entity.Contact;

public interface IcontactService {

    boolean saveContact(ContactRequestDto contactRequestDto);
}
