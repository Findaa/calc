package com.upcprovision.calc.repos;

import com.upcprovision.calc.security.RegisterVerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepo extends JpaRepository<RegisterVerificationToken, Long> {
List<RegisterVerificationToken> findAllByToken(String token);
RegisterVerificationToken getByToken(String token);
}
