# Reward Distribution Manager

The **Reward Distribution Manager** is a core module within the Hypernode ecosystem designed to facilitate the seamless calculation and distribution of rewards for participants. It ensures that rewards are managed transparently, efficiently, and in line with the system's configuration rules.

---

## Features

### Referral Management
- **Track Referrals**: Monitor who referred whom and maintain a record of all referral-based activities.
- **Reward Calculations**: Automatically compute rewards based on successful referrals and activity contributions.

### Reward Distribution
- **Automated Payouts**: Distribute rewards to participants based on their activities.
- **Flexible Configurations**: Adjust reward policies and thresholds using configuration files.

### Dashboard
- **Visualization**: A simple dashboard to view user rewards and referral statistics.
- **API-Driven**: Accessible endpoints for integration with other systems.

---

## Repository Structure

### Core Files
- **`ReferralManager.java`**: The central Java class managing referrals and calculating rewards.
- **`RewardCalculator.java`**: Handles reward computations based on different policies.
- **`RewardDistributor.java`**: Manages the automated distribution of computed rewards.
- **`ReferralConfig.properties`**: Configurable settings for referral rewards.
- **`RewardDistributionConfig.properties`**: Configurable settings for reward distribution.

### Supporting Files
- **`ReferralDashboard.js`**: A web-based dashboard to visualize referral and reward data.
- **`setup.md`**: Instructions for setting up the module.
- **`README.md`**: Overview of the module (this file).

---

## Configuration

### ReferralConfig.properties
```properties
# Referral Configuration
reward.per.referral=10
max.referrals.per.user=50
enable.notifications=true
```

### RewardDistributionConfig.properties
```properties
# Reward Distribution Configuration
payout.threshold=100
payment.method=crypto
payment.token=Hypernode
```

---

## API Usage

### Referral Dashboard Endpoints

#### Fetch Referral Data
- **Endpoint**: `/api/referrals/:user`
- **Method**: `GET`
- **Response**:
  ```json
  {
    "referred": ["Bob", "Charlie"],
    "rewards": 20
  }
  ```

#### Add a New Referral
- **Endpoint**: `/api/referrals`
- **Method**: `POST`
- **Body**:
  ```json
  {
    "referrer": "Alice",
    "referred": "Bob"
  }
  ```

---

## Setup and Deployment

1. Clone the repository:
   ```bash
   git clone https://github.com/Hypernode/rewarddistributionmanager.git
   ```

2. Compile and run the Java components:
   ```bash
   javac com/Hypernode/referrals/*.java
   java com.Hypernode.referrals.ReferralManager
   ```

3. Start the Referral Dashboard:
   ```bash
   node ReferralDashboard.js
   ```

4. Access the dashboard at `http://localhost:3000`.

---

## Contribution Guidelines

We welcome contributions to improve the **Reward Distribution Manager**. Please follow these steps:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes with clear messages.
4. Submit a pull request.

---
