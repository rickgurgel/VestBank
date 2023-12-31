package com.rickgurgel.VestBank.resources;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rickgurgel.VestBank.domain.Account;
import com.rickgurgel.VestBank.dto.AccountDTO;
import com.rickgurgel.VestBank.services.AccountService;

@RestController
@RequestMapping(value="/accounts")
public class AccountResource {
	
	@Autowired
	private AccountService service;
	
	@GetMapping
	public ResponseEntity<List<AccountDTO>> findAll(){
		List<Account> list = service.findAll();
		List<AccountDTO> listDto = list.stream().map(x -> new AccountDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> findById(@PathVariable String id){
		Account obj = service.findById(id);
		return ResponseEntity.ok().body(new AccountDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AccountDTO objDto){
		Account obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody AccountDTO objDto, @PathVariable String id){
		Account obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}/deposit")
    public Account deposit(@PathVariable String id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return service.deposit(id, amount);
    }

    @PutMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable String id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return service.withdraw(id, amount);
    }
	
}
