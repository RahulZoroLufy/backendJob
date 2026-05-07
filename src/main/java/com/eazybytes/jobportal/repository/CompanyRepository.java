package com.eazybytes.jobportal.repository;

import com.eazybytes.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // this is an optional spring by default creates bean for this
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
