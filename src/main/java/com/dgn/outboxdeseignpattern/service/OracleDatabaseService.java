package com.dgn.outboxdeseignpattern.service;

import com.dgn.outboxdeseignpattern.model.OracleDatabase;
import com.dgn.outboxdeseignpattern.repository.OracleDatabaseRepository;
import org.springframework.stereotype.Service;

@Service
public class OracleDatabaseService {

    private final OracleDatabaseRepository oracleDatabaseRepository;

    public OracleDatabaseService(OracleDatabaseRepository oracleDatabaseRepository) {
        this.oracleDatabaseRepository = oracleDatabaseRepository;
    }

    public OracleDatabase addOracleDatabase(OracleDatabase oracleDatabase){
        return oracleDatabaseRepository.save(oracleDatabase);
    }
}
