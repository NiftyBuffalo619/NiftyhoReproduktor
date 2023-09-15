package wannabeNifty.NiftyhoReproduktor;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.jetbrains.annotations.NotNull;

public class CommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        TextInput musicName = TextInput.create("musicname", "Music Name", TextInputStyle.SHORT)
                .setPlaceholder("Some Music you want to play")
                .setMinLength(4)
                .setMaxLength(30)
                .build();
        Modal modal = Modal.create("musicmodal", "Music")
                .addActionRows(ActionRow.of(musicName))
                .build();

        switch (event.getName()) {
            case "play":
                    event.replyModal(modal);
                break;
        }
    }
}
