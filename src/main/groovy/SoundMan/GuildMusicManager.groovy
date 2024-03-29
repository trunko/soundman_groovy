package SoundMan

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager

/**
 * Holder for both the player and a track scheduler for one guild.
 */
class GuildMusicManager {
    /**
     * Audio player for the guild.
     */
    final AudioPlayer player
    /**
     * Track scheduler for the player.
     */
    final TrackScheduler scheduler

    /**
     * Creates a player and a track scheduler.
     *
     * @param manager Audio player manager to use for creating the player.
     */
    GuildMusicManager(AudioPlayerManager manager) {
        player = manager.createPlayer()
        scheduler = new TrackScheduler(player)
        player.addListener(scheduler)
    }

    /**
     * @return Wrapper around AudioPlayer to use it as an AudioSendHandler.
     */
    AudioPlayerSendHandler getSendHandler() {
        return new AudioPlayerSendHandler(player)
    }
}
