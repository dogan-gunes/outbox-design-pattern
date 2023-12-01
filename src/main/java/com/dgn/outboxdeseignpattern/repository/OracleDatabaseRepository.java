package com.dgn.outboxdeseignpattern.repository;

import com.dgn.outboxdeseignpattern.model.OracleDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleDatabaseRepository extends JpaRepository<OracleDatabase,Long> {
}
