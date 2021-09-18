package com.id.simian.userservice.repository;

import com.id.simian.userservice.entity.AuthenticationAcl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationAclRepository extends JpaRepository<AuthenticationAcl, Long> {
}
