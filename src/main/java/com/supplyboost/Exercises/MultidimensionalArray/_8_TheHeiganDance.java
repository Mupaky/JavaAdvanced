package com.supplyboost.Exercises.MultidimensionalArray;

import java.util.Scanner;

public class _8_TheHeiganDance {
    // Constants for the game
    private static final int CHAMBER_SIZE = 15;
    private static final int PLAYER_START_HP = 18500;
    private static final double HEIGAN_START_HP = 3000000;
    private static final int CLOUD_DAMAGE = 3500;
    private static final int ERUPTION_DAMAGE = 6000;

    // Variables to track game state
    private static double heiganHP = HEIGAN_START_HP;
    private static int playerHP = PLAYER_START_HP;
    private static int playerRow = 7;
    private static int playerCol = 7;
    private static boolean isCloudActive = false;
    private static String lastSpell = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        while (true) {
            // The player deals damage to Heigan
            heiganHP -= damageToHeigan;

            // Apply Plague Cloud damage if active
            applyCloudDamage();

            // Check if the player is dead after cloud damage
            if (playerHP <= 0) {
                break;
            }

            // Check if Heigan is defeated
            boolean isHeiganDefeated = heiganHP <= 0;

            // If Heigan is dead, he doesn't cast spells
            String spell = "";
            int spellRow = -1;
            int spellCol = -1;
            if (!isHeiganDefeated) {
                // Read Heigan's spell
                String[] input = scanner.nextLine().split("\\s+");
                spell = input[0];
                spellRow = Integer.parseInt(input[1]);
                spellCol = Integer.parseInt(input[2]);

                // Determine if the player's position is within the damage area
                if (isPlayerInDamageArea(spellRow, spellCol)) {
                    // Attempt to move the player
                    if (!attemptToMove(spellRow, spellCol)) {
                        // Player couldn't move, apply spell damage
                        applySpellDamage(spell);
                    }
                }
            }

            // Check if the player is dead after taking damage
            if (playerHP <= 0) {
                if (spell.equals("Cloud")) {
                    lastSpell = "Plague Cloud";
                } else if (!spell.isEmpty()) {
                    lastSpell = spell;
                }
                break;
            }

            // If both Heigan and the player are dead, exit the loop
            if (isHeiganDefeated) {
                break;
            }
        }

        // Print the final results
        printFinalResults();
    }

    // Apply Plague Cloud damage if active
    private static void applyCloudDamage() {
        if (isCloudActive) {
            playerHP -= CLOUD_DAMAGE;
            isCloudActive = false; // Cloud effect expires after this turn
            if (playerHP <= 0) {
                lastSpell = "Plague Cloud";
            }
        }
    }

    // Determine if the player's position is within the spell's damage area
    private static boolean isPlayerInDamageArea(int spellRow, int spellCol) {
        int startRow = spellRow - 1;
        int endRow = spellRow + 1;
        int startCol = spellCol - 1;
        int endCol = spellCol + 1;

        return playerRow >= startRow && playerRow <= endRow && playerCol >= startCol && playerCol <= endCol;
    }

    // Attempt to move the player to a safe cell
    private static boolean attemptToMove(int spellRow, int spellCol) {
        // Define the directions in the order: up, right, down, left
        int[][] directions = {
                {-1, 0}, // up
                {0, 1},  // right
                {1, 0},  // down
                {0, -1}  // left
        };

        for (int[] dir : directions) {
            int newRow = playerRow + dir[0];
            int newCol = playerCol + dir[1];

            if (isInBounds(newRow, newCol) && !isCellInDamageArea(newRow, newCol, spellRow, spellCol)) {
                // Move the player to the new position
                playerRow = newRow;
                playerCol = newCol;
                return true; // Successfully moved
            }
        }
        return false; // Couldn't move
    }

    // Check if a specific cell is within the spell's damage area
    private static boolean isCellInDamageArea(int row, int col, int spellRow, int spellCol) {
        int startRow = spellRow - 1;
        int endRow = spellRow + 1;
        int startCol = spellCol - 1;
        int endCol = spellCol + 1;

        return row >= startRow && row <= endRow && col >= startCol && col <= endCol;
    }

    // Apply damage from Heigan's spell to the player
    private static void applySpellDamage(String spell) {
        if (spell.equals("Cloud")) {
            playerHP -= CLOUD_DAMAGE;
            isCloudActive = true; // Cloud effect lasts for one more turn
            lastSpell = "Plague Cloud";
        } else if (spell.equals("Eruption")) {
            playerHP -= ERUPTION_DAMAGE;
            lastSpell = "Eruption";
        }
    }

    // Check if a cell is within the chamber bounds
    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < CHAMBER_SIZE && col >= 0 && col < CHAMBER_SIZE;
    }

    // Print the final results after the battle ends
    private static void printFinalResults() {
        // Print Heigan's status
        if (heiganHP <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHP);
        }

        // Print player's status
        if (playerHP <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerHP);
        }

        // Print final position
        System.out.println("Final position: " + playerRow + ", " + playerCol);
    }
}
