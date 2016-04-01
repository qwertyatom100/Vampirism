package de.teamlapen.vampirism.api.entity.factions;

import de.teamlapen.vampirism.api.entity.player.IFactionPlayer;

/**
 * Handles factions and levels for the player
 */
public interface IFactionPlayerHandler {

    /**
     * Players can only join a faction if they are in no other.
     *
     * @param faction
     * @return If the player can join the given faction
     */
    boolean canJoin(IPlayableFaction faction);

    /**
     * Checks currents factions {@link IFactionPlayer#canLeaveFaction()}
     */
    boolean canLeaveFaction();

    /**
     * @return The currently active faction. Can be null
     */
    IPlayableFaction getCurrentFaction();

    /**
     * @return The currently active faction player. Can be null
     */
    IFactionPlayer getCurrentFactionPlayer();

    /**
     * If no faction is active this returns 0.
     * Prefer using {@link IFactionPlayer#getLevel()} unless you are checking your own faction, since other factions might handle things differently
     *
     * @return the level of the currently active faction
     */
    int getCurrentLevel();

    /**
     * Makes some things easier.
     * Prefer using {@link IFactionPlayer#getLevel()} unless you are checking your own faction, since other factions might handle things differently
     *
     * @param f
     * @return If the faction is active: The faction level, otherwise 0
     */
    int getCurrentLevel(IPlayableFaction f);

    /**
     * @param f
     * @return If the given faction is equal to the current one
     */
    boolean isInFaction(IPlayableFaction f);

    /**
     * Join the given faction and set the faction level to 1.
     * Only successful if {@link IFactionPlayerHandler#canJoin(IPlayableFaction)}
     *
     * @param faction
     */
    void joinFaction(IPlayableFaction faction);

    /**
     * Set the players faction and it's level. Only use this if you are sure that you want to override the previous faction.
     *
     * @param faction
     * @param level
     * @return If successful
     */
    boolean setFactionAndLevel(IPlayableFaction faction, int level);

    /**
     * Set the level for a faction. Only works if the player already is in the given faction.
     * Use {@link IFactionPlayerHandler#joinFaction(IPlayableFaction)} to join a faction first or {@link IFactionPlayerHandler#setFactionAndLevel(IPlayableFaction, int)} if you are sure what you do
     *
     * @param faction
     * @param level
     * @return If successful
     */
    boolean setFactionLevel(IPlayableFaction faction, int level);
}