package com.rickgurgel.VestBank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rickgurgel.VestBank.domain.Deposit;

@Repository
public interface DepositRepository extends MongoRepository<Deposit, String>{

}
