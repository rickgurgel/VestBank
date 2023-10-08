package com.rickgurgel.VestBank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rickgurgel.VestBank.domain.Withdraw;

@Repository
public interface WithdrawRepository extends MongoRepository<Withdraw, String>{

}
