package com.upcprovision.calc.repos;

import antlr.Token;
import com.upcprovision.calc.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepo extends JpaRepository<VerificationToken, Long> {
List<VerificationToken> findAllByToken(String token);
VerificationToken getByToken(String token);
}
