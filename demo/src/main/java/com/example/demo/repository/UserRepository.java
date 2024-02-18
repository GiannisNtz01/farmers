//UserRepository.java

package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    // Προσθήκη μεθόδου για την ανάκτηση ενός χρήστη βάσει του ID του
    User findById(long id);

    // Προσθήκη μεθόδου για την αποθήκευση ενός νέου χρήστη
    User save(User user);

    // Προσθήκη μεθόδου για τη διαγραφή ενός χρήστη βάσει του ID του
    void deleteById(long id);
}

// ΠΕΡΙΜΕΝΕ, ΜΗΝ ΞΕΚΙΝΗΣΕΙΣ ΤΗΝ ΑΝΑΠΤΥΞΗ ΑΚΟΜΑ. ΕΧΕΙ ΚΙΑΛΛΑ ΚΟΜΜΑΤΙΑ ΚΩΔΙΚΑ.