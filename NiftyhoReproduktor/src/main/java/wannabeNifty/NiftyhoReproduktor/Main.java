package wannabeNifty.NiftyhoReproduktor;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JDA bot = JDABuilder.createDefault("")
                .setActivity(Activity.listening("Music"))
                .addEventListeners(new CommandListener(), new ModalListener())
                .build().awaitReady();
    }
}
