import React, { useState } from 'react';

const CompensationForm = () => {
  const [location, setLocation] = useState('');
  const [description, setDescription] = useState('');
  const [amount, setAmount] = useState('');

  const handleSubmit = () => {
    // υλοπ
  };

  return (
    <div>
      <h2>Compensation Form</h2>
      <input type="text" placeholder="Location" value={location} onChange={(e) => setLocation(e.target.value)} />
      <input type="text" placeholder="Description" value={description} onChange={(e) => setDescription(e.target.value)} />
      <input type="number" placeholder="Amount" value={amount} onChange={(e) => setAmount(e.target.value)} />
      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
};

export default CompensationForm;
