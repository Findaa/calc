package com.upcprovision.calc.repos.tickets;

import com.upcprovision.calc.model.tickets.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ClientRepo extends JpaRepository<Client, Long> {
Client findAllById(Long id);
List<Client> findAllByFlatAfterAndBuildingAfterOrderByStreet(String flat, String bilding);
}
