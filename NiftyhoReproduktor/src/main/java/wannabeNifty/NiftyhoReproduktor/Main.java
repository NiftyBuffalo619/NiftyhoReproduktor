package wannabeNifty.NiftyhoReproduktor;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    JDA bot = JDABuilder.createDefault("token")
            .setActivity(Activity.listening("Music"))
            .addEventListeners(new CommandListener())
            .build();
}
