package com.hypernode.referrals;

import java.util.*;

/**
 * ReferralManager - Manages the referral system for hypernode.
 * Tracks referrals, calculates rewards, and provides data for analytics.
 */
public class ReferralManager {

    private final Map<String, String> referralMap; // Maps referred user to referrer
    private final Map<String, Integer> rewardBalances; // Tracks rewards for referrers
    private final int rewardPerReferral; // Configurable reward per referral

    /**
     * Constructor for ReferralManager.
     *
     * @param rewardPerReferral Reward points granted per successful referral.
     */
    public ReferralManager(int rewardPerReferral) {
        this.referralMap = new HashMap<>();
        this.rewardBalances = new HashMap<>();
        this.rewardPerReferral = rewardPerReferral;
    }

    /**
     * Registers a new referral.
     *
     * @param referrer The user who made the referral.
     * @param referred The new user being referred.
     * @return True if the referral was successfully registered, false otherwise.
     */
    public boolean registerReferral(String referrer, String referred) {
        if (referralMap.containsKey(referred)) {
            System.err.println("[ERROR] User " + referred + " is already referred.");
            return false;
        }
        referralMap.put(referred, referrer);
        rewardBalances.put(referrer, rewardBalances.getOrDefault(referrer, 0) + rewardPerReferral);
        System.out.println("[INFO] Referral registered: " + referrer + " referred " + referred);
        return true;
    }

    /**
     * Retrieves the reward balance for a user.
     *
     * @param user The user whose reward balance is requested.
     * @return The reward balance for the user.
     */
    public int getRewardBalance(String user) {
        return rewardBalances.getOrDefault(user, 0);
    }

    /**
     *   Displays the referral map for debugging or analytics.
     */
    public void displayReferrals() {
        System.out.println("[INFO] Current Referrals:");
        referralMap.forEach((referred, referrer) ->
            System.out.println("- " + referred + " referred by " + referrer)
        );
    }

    public static void main(String[] args) {
        // Example usage
        ReferralManager manager = new ReferralManager(10); // 10 reward points per referral

        // Register referrals
        manager.registerReferral("Alice", "Bob");
        manager.registerReferral("Alice", "Charlie");
        manager.registerReferral("Bob", "David");

        // Check reward balances
        System.out.println("Alice's Reward Balance: " + manager.getRewardBalance("Alice"));
        System.out.println("Bob's Reward Balance: " + manager.getRewardBalance("Bob"));

        // Display all referrals
        manager.displayReferrals();
    }
}
