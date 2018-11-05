/**
 * done
 */


package com.upcprovision.calc.repos.provision;

import com.upcprovision.calc.model.provision.Deals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface DealsRepo extends CrudRepository<Deals, Long> {
    List<Deals> findAllByLog(String log);
    Deals findAllById(Long id);
}
