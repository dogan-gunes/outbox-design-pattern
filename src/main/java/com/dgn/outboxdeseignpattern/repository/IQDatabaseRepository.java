package com.dgn.outboxdeseignpattern.repository;

import com.dgn.outboxdeseignpattern.model.IQDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQDatabaseRepository extends JpaRepository<IQDatabase,Long> {
}
