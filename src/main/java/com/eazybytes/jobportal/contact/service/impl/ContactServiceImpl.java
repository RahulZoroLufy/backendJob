package com.eazybytes.jobportal.contact.service.impl;

import com.eazybytes.jobportal.contact.service.IcontactService;
import com.eazybytes.jobportal.dto.ContactRequestDto;
import com.eazybytes.jobportal.entity.Contact;
import com.eazybytes.jobportal.repository.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements IcontactService {

    private ContactRepository contactRepository;

   public ContactServiceImpl(ContactRepository contactRepository) {
       this.contactRepository = contactRepository;
   }


    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
       boolean result = false;
        Contact contact = contactRepository.save(transformToEntity(contactRequestDto));
        if (contact != null && contact.getId() != null) {
            result = true;
        }
        return result;
    }

    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
       Contact contact = new Contact();
       BeanUtils.copyProperties(contactRequestDto, contact);
       contact.setStatus("New");
       return contact;
    }
}
