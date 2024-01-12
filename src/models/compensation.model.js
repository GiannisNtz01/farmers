// models/compensation.model.js
const mongoose = require('mongoose');

const compensationSchema = new mongoose.Schema({
    compensationId: String,
    applicant: String,
    location: String,
    description: String,
    status: String,
    amount: Number,
    inspector: String
});

const Compensation = mongoose.model('Compensation', compensationSchema);

module.exports = Compensation;
