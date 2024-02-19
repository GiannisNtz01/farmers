//CompensationService.java

package com.example.demo.service;

import com.example.demo.repository.CompensationRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Compensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationService {

    @Autowired
    private CompensationRepository compensationRepository;

    public List<Compensation> getAllCompensations() {
        return compensationRepository.findAll();
    }

    public Compensation getCompensationById(Long id) {
        return compensationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compensation", "id", id));
    }

    public Compensation createCompensation(Compensation compensation) {
        return compensationRepository.save(compensation);
    }

    public Compensation updateCompensation(Long id, Compensation newCompensation) {
        Compensation existingCompensation = compensationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        existingCompensation.setLocation(newCompensation.getLocation());
        existingCompensation.setDescription(newCompensation.getDescription());
        existingCompensation.setAmount(newCompensation.getAmount());

        return compensationRepository.save(existingCompensation);
    }

    public void deleteCompensation(Long id) {
        compensationRepository.deleteById(id);
    }
}

// ΠΕΡΙΜΕΝΕ, ΜΗΝ ΞΕΚΙΝΗΣΕΙΣ ΤΗΝ ΑΝΑΠΤΥΞΗ ΑΚΟΜΑ. ΕΧΕΙ ΚΙΑΛΛΑ ΚΟΜΜΑΤΙΑ ΚΩΔΙΚΑ.