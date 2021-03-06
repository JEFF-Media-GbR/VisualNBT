package de.jeff_media.nbtviewer.conversation;

import de.jeff_media.nbtviewer.util.ChatUtils;
import de.jeff_media.nbtviewer.util.NBTUtils;
import de.jeff_media.nbtviewer.gui.menu.PluginMenu;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.ValidatingPrompt;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.Map;

import static de.jeff_media.nbtviewer.util.NBTUtils.*;

public class NamespacePrompt extends de.jeff_media.nbtviewer.conversation.Prompt {

    @NotNull
    @Override
    public String getPromptText(@NotNull ConversationContext context) {
        return PROMPT_COLOR + "\nEnter Namespace / Plugin" + OR_CANCEL+":";
    }

    @Override
    protected boolean isInputValid(@NotNull ConversationContext context, @NotNull String input) {
        return input.length() > 0 && input.toLowerCase(Locale.ROOT).matches("[a-z0-9_.-]+");
    }

    @Nullable
    @Override
    protected Prompt acceptValidatedInput(@NotNull ConversationContext context, @NotNull String input) {
        context.setSessionData("namespace",input.toLowerCase(Locale.ROOT));
        return new KeyPrompt();
    }

}
