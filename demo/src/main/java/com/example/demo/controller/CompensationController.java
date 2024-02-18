//CompensationController.java

// CompensationController.java

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.CompensationRepository;
import com.example.demo.model.Compensation;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/compensations")
public class CompensationController {

    @Autowired
    private CompensationRepository compensationRepository;

    @GetMapping
    public List<Compensation> getAllCompensations() {
        return compensationRepository.findAll();
    }

    @PostMapping
    public Compensation createCompensation(@RequestBody Compensation compensation) {
        return compensationRepository.save(compensation);
    }

    @PutMapping("/{id}")
    public Compensation updateCompensation(@PathVariable Long id, @RequestBody Compensation compensationDetails) {
        Compensation compensation = compensationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compensation", "id", id));

        compensation.setLocation(compensationDetails.getLocation());
        compensation.setDescription(compensationDetails.getDescription());
        compensation.setAmount(compensationDetails.getAmount());

        return compensationRepository.save(compensation);
    }

    @DeleteMapping("/{id}")
    public void deleteCompensation(@PathVariable Long id) {
        compensationRepository.deleteById(id);
    }
}

// ΠΕΡΙΜΕΝΕ, ΜΗΝ ΞΕΚΙΝΗΣΕΙΣ ΤΗΝ ΑΝΑΠΤΥΞΗ ΑΚΟΜΑ. ΕΧΕΙ ΚΙΑΛΛΑ ΚΟΜΜΑΤΙΑ ΚΩΔΙΚΑ.