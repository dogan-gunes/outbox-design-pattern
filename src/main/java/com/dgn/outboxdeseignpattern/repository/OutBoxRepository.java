package com.dgn.outboxdeseignpattern.repository;

import com.dgn.outboxdeseignpattern.model.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutBoxRepository extends JpaRepository<Outbox,Long> {
}
