package creman.fog.commands;

import creman.fog.api.FogUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.Collections;
import java.util.List;


public class FogCommand extends CommandBase
{
    private final String[] subtypes = {"color", "density", "natural"};
    @Override
    public String getName()
    {
        return "fog";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return  "commands.fog.usage";
    }

    public void sendUsage(ICommandSender sender, String subtype)
    {
        String translation = String.format("commands.%s.usage", subtype);
        sender.sendMessage(new TextComponentTranslation(translation));
    }
    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String [] args) throws CommandException
    {
        if (args.length == 0)
        {
            sendUsage(sender, getName());
            return;
        }
        if (args[0].equals("color"))
        {
            if (args.length == 5 || args.length == 4)
            {
                EntityPlayerMP entityplayermp;
                byte supplement = 0;
                if (args.length == 5) {
                    entityplayermp = getPlayer(server, sender, args[1]);
                    supplement = 1;
                }
                else {
                    entityplayermp = getCommandSenderAsPlayer(sender);
                }

                try
                {
                    FogUtil.SetFogColor(entityplayermp, Float.parseFloat(args[1 + supplement]), Float.parseFloat(args[2 + supplement]), Float.parseFloat(args[3 + supplement]));
                }
                catch (NumberFormatException e)
                {
                    sendUsage(sender, subtypes[0]);
                }
            }
            else
            {
                sendUsage(sender, subtypes[0]);
            }
        }
        if (args[0].equals("density"))
        {
            if (args.length == 3 || args.length == 2)
            {
                EntityPlayerMP entityplayermp;
                byte supplement = 0;
                if (args.length == 3) {
                    entityplayermp = getPlayer(server, sender, args[1]);
                    supplement = 1;
                }
                else {
                    entityplayermp = getCommandSenderAsPlayer(sender);
                }

                try
                {
                    FogUtil.SetFogDensity(entityplayermp, Float.parseFloat(args[1 + supplement]));
                }
                catch (NumberFormatException e)
                {
                    sendUsage(sender, subtypes[1]);
                }
            }
            else
            {
                sendUsage(sender, subtypes[1]);
            }
        }
        if (args[0].equals("natural"))
        {
            if (args.length == 3 || args.length == 2)
            {
                EntityPlayerMP entityplayermp;
                byte supplement = 0;
                if (args.length == 3) {
                    entityplayermp = getPlayer(server, sender, args[1]);
                    supplement = 1;
                }
                else {
                    entityplayermp = getCommandSenderAsPlayer(sender);
                }
                FogUtil.SetFogNatural(entityplayermp, Boolean.parseBoolean(args[1 + supplement]));
            }
            else
            {
                sendUsage(sender, subtypes[2]);
            }
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
    {
        if (args.length == 1)
        {
            return getListOfStringsMatchingLastWord(args, subtypes);
        }
        else if (args.length == 2)
        {
            return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
        }
//        else if (args.length == 3 && args[0].equals("natural"))
//        {
//            return getListOfStringsMatchingLastWord(new String[]{"true, false"});
//        }
        else
        {
            return Collections.emptyList();
        }
    }
}
