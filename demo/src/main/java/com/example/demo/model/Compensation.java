// Compensation.java

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compensation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicant;
    private String location;
    private String description;
    private Status status;
    private Double amount;
    private String inspector;

    public String getLocation() {
        return this.location;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public enum Status {
        APPROVED,
        REJECTED,
        PENDING
    }
}

// ΠΕΡΙΜΕΝΕ, ΜΗΝ ΞΕΚΙΝΗΣΕΙΣ ΤΗΝ ΑΝΑΠΤΥΞΗ ΑΚΟΜΑ. ΕΧΕΙ ΚΙΑΛΛΑ ΚΟΜΜΑΤΙΑ ΚΩΔΙΚΑ.