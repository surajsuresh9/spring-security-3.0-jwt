package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.UserCredential;
import com.google.common.base.Optional;

public interface UserCredentialRepo extends JpaRepository<UserCredential, Integer> {

	Optional<UserCredential> findByName(String username);

}
