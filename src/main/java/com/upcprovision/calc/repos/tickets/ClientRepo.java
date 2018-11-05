package com.upcprovision.calc.repos.tickets;

import com.upcprovision.calc.model.tickets.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client, Long> {
Client findAllById(Long id);
List<Client> findAllByFlatAfterAndBuildingAfterOrderByStreet(String flat, String bilding);
}
