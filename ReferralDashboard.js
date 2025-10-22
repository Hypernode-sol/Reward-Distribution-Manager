// ReferralDashboard.js - A simple dashboard for managing referral rewards

const express = require('express');
const app = express();
const PORT = 3000;

// Mock data (replace with database integration in production)
const referrals = {
  Alice: { referred: ['Bob', 'Charlie'], rewards: 20 },
  Bob: { referred: ['David'], rewards: 10 },
};

app.use(express.json());

// Endpoint to fetch referral data for a specific user
app.get('/api/referrals/:user', (req, res) => {
  const user = req.params.user;
  if (referrals[user]) {
    res.json(referrals[user]);
  } else {
    res.status(404).json({ error: 'User not found' });
  }
});

// Endpoint to add a new referral
app.post('/api/referrals', (req, res) => {
  const { referrer, referred } = req.body;

  if (!referrer || !referred) {
    return res.status(400).json({ error: 'Referrer and referred are required.' });
  }

  if (!referrals[referrer]) {
    referrals[referrer] = { referred: [], rewards: 0 };
  }

  if (referrals[referrer].referred.includes(referred)) {
    return res.status(400).json({ error: 'This referral already exists.' });
  }

  referrals[referrer].referred.push(referred);
  referrals[referrer].rewards += 10; // Assuming 10 points per referral
  res.status(201).json({ message: 'Referral added successfully.' });
});

// Homepage for the dashboard
app.get('/', (req, res) => {
  res.send(`
    <h1>Referral Dashboard</h1>
    <p>Use the API to manage referrals:</p>
    <ul>
      <li>GET /api/referrals/:user - Fetch referral data for a specific user</li>
      <li>POST /api/referrals - Add a new referral</li>
    </ul>
  `);
});

// Start the server
app.listen(PORT, () => {
  console.log(`Referral Dashboard running at http://localhost:${PORT}`);
});
