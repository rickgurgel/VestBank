package com.rickgurgel.VestBank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rickgurgel.VestBank.domain.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{

}
