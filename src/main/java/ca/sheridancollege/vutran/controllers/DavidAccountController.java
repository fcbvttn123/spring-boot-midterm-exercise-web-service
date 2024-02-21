package ca.sheridancollege.vutran.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.vutran.AccountRepo;
import ca.sheridancollege.vutran.beans.Account;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class DavidAccountController {
	private AccountRepo ar;
	
	@GetMapping
    public List<Account> getAllAccount() {
        return ar.findAll();
    }
	
	@GetMapping(value = "{id}") 
    public Account getIndividualAccount(@PathVariable("id") Long id) {
        return ar.findById(id).get();
    }
	
	@PostMapping(consumes = "application/json")
    public Account postACcount(@RequestBody Account a) {
        return ar.save(a);
    }
	
	@PutMapping(consumes = "application/json")
    public String putAccountCollection(@RequestBody List<Account> aList) {
        ar.deleteAll();
        ar.saveAll(aList);
        return "Total Records: " + ar.count();
    }
	
    @PutMapping(value = "{id}", consumes = "application/json")
    public List<Account> putStudent(@RequestBody Account a, @PathVariable("id") Long id) {
        ar.deleteById(id);
        ar.save(a);
        return ar.findAll();
    }
    
    @DeleteMapping(value = "{id}")
    public String deleteAccount(@PathVariable("id") Long id) {
        ar.deleteById(id);
        return "Deleted id: " + id;
    }
    
    @DeleteMapping
    public String deleteAll() {
        ar.deleteAll();
        return "Deleted All";
    }
}
