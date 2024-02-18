//CompensationRepository.java
// Το πακετο JpaRepository βοηθαει την διαχειριση του compensation στην βαση δεδομενων, δεν χρειαζεται κατι περαιτερω
package com.example.demo.repository;

import com.example.demo.model.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {
}

// ΠΕΡΙΜΕΝΕ, ΜΗΝ ΞΕΚΙΝΗΣΕΙΣ ΤΗΝ ΑΝΑΠΤΥΞΗ ΑΚΟΜΑ. ΕΧΕΙ ΚΙΑΛΛΑ ΚΟΜΜΑΤΙΑ ΚΩΔΙΚΑ.