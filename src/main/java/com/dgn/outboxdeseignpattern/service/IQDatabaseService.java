package com.dgn.outboxdeseignpattern.service;

import com.dgn.outboxdeseignpattern.model.IQDatabase;
import com.dgn.outboxdeseignpattern.repository.IQDatabaseRepository;
import org.springframework.stereotype.Service;

@Service
public class IQDatabaseService {
    private final IQDatabaseRepository iqDatabaseRepository;

    public IQDatabaseService(IQDatabaseRepository iqDatabaseRepository) {
        this.iqDatabaseRepository = iqDatabaseRepository;
    }

    public IQDatabase addIQDatabase(IQDatabase iqDatabase){
        return iqDatabaseRepository.save(iqDatabase);
    }
}
