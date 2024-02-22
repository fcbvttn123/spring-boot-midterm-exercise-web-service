package ca.sheridancollege.vutran.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.vutran.beans.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
