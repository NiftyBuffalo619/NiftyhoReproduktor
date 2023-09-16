package wannabeNifty.NiftyhoReproduktor;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.concurrent.BlockingQueue;

public class MusicListener extends ListenerAdapter {
    private final AudioPlayerManager playerManager;
    /*private final BlockingQueue<AudioTrack> trackQueue;
    private final AudioPlayer player;
    private final AudioSourceManager sourceManager;*/

    public MusicListener() {
        this.playerManager = new DefaultAudioPlayerManager();
        this.playerManager.registerSourceManager(new YoutubeAudioSourceManager());
    }

    public static void ConnectAndPlay(Member member, ModalInteractionEvent event) {
        if (member != null) {
            VoiceChannel voiceChannel = member.getVoiceState().getChannel().asVoiceChannel();
            if (voiceChannel != null) {
                AudioManager audioManager = event.getGuild().getAudioManager();
                audioManager.openAudioConnection(voiceChannel);
            } else {
              event.getChannel().asTextChannel().sendMessage("You need to be in a voice chat");
            }
        }
    }
}
