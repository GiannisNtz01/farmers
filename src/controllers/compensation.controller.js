// controllers/compensation.controller.js
const Compensation = require('../models/compensation.model');

exports.getAllCompensations = async (req, res) => {
    try {
        const compensations = await Compensation.find();
        res.json(compensations);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

exports.createCompensation = async (req, res) => {
    const compensation = new Compensation({
        compensationId: req.body.compensationId,
        applicant: req.body.applicant,
        location: req.body.location,
        description: req.body.description,
        status: req.body.status,
        amount: req.body.amount,
        inspector: req.body.inspector
    });

    try {
        const newCompensation = await compensation.save();
        res.status(201).json(newCompensation);
    } catch (error) {
        res.status(400).json({ message: error.message });
    }
};
