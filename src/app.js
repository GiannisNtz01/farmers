const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const app = express();
const port = process.env.PORT || 3000;

// Σύνδεση στη βάση δεδομένων (αντικαταστήστε 'your-database-name' με το όνομα της πραγματικής σας βάσης)
mongoose.connect('mongodb://localhost:27017/farmersDB', { useNewUrlParser: true, useUnifiedTopology: true });

//θα προστεθει μαζι με το frontend
//παραδειγμα
// db.compensations.insertMany([
//     {
//         compensationId: "1",
//         applicant: "Κώστας Παπαδόπουλος",
//         location: "Αθήνα",
//         description: "Ζημιά σε οχήμα λόγω ατυχήματος",
//         status: "Υποβλήθηκε",
//         amount: 1000,
//         inspector: "Γιάννης Σταυρόπουλος"
//     },
//     {
//         compensationId: "2",
//         applicant: "Μαρία Νικολάου",
//         location: "Θεσσαλονίκη",
//         description: "Ζημιά σε κατοικία λόγω πυρκαγιάς",
//         status: "Σε εξέλιξη",
//         amount: 5000,
//         inspector: "Αναστασία Παπαδοπούλου"
//     }
// ])


// Ορισμός του μοντέλου για τα Compensation
const Compensation = mongoose.model('Compensation', {
    compensationId: String,
    applicant: String,
    location: String,
    description: String,
    status: String,
    amount: Number,
    inspector: String
});

// Middleware για τον έλεγχο των JSON αιτημάτων
app.use(bodyParser.json());

// Ορισμός ενός endpoint για τη δημιουργία μιας νέας Compensation
app.post('/compensations', async (req, res) => {
    try {
        const compensation = new Compensation(req.body);
        await compensation.save();
        res.send(compensation);
    } catch (error) {
        res.status(500).send(error);
    }
});

// Ορισμός ενός endpoint για την ανάγνωση όλων των Compensations
app.get('/compensations', async (req, res) => {
    try {
        const compensations = await Compensation.find();
        res.send(compensations);
    } catch (error) {
        res.status(500).send(error);
    }
});

// Ορισμός ενός endpoint για την ανάγνωση μιας συγκεκριμένης Compensation με βάση το ID
app.get('/compensations/:id', async (req, res) => {
    try {
        const compensation = await Compensation.findById(req.params.id);
        res.send(compensation);
    } catch (error) {
        res.status(500).send(error);
    }
});

// Ορισμός ενός endpoint για την ενημέρωση μιας Compensation με βάση το ID
app.patch('/compensations/:id', async (req, res) => {
    try {
        await Compensation.findByIdAndUpdate(req.params.id, req.body);
        res.send('Η Compensation ενημερώθηκε με επιτυχία');
    } catch (error) {
        res.status(500).send(error);
    }
});

// Ορισμός ενός endpoint για τη διαγραφή μιας Compensation με βάση το ID
app.delete('/compensations/:id', async (req, res) => {
    try {
        await Compensation.findByIdAndDelete(req.params.id);
        res.send('Η Compensation διαγράφηκε με επιτυχία');
    } catch (error) {
        res.status(500).send(error);
    }
});

// Έναρξη του server
app.listen(port, () => {
    console.log(`Ο server τρέχει στη θύρα ${port}`);
});
