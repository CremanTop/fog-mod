package creman.fog.commands;

import creman.fog.api.FogUtil;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Collections;
import java.util.List;


public class FogCommand extends CommandBase
{
    private String[] subtypes = {"color", "density"};
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
    public void execute(MinecraftServer server, ICommandSender sender, String [] args) throws CommandException
    {
        EntityPlayerMP entityplayermp = getPlayer(server, sender, sender.getName());
        if (args.length == 0)
        {
            sendUsage(sender, getName());
            return;
        }
        if (args[0].equals("color"))
        {
            if (args.length == 4)
            {
                execute4Color(sender, entityplayermp, args[1], args[2], args[3]);
            }
            else
            {
                sendUsage(sender, subtypes[0]);
            }
        }
        if (args[0].equals("density"))
        {
            if (args.length == 2)
            {
                execute4Density(sender, entityplayermp, args[1]);
            }
            else
            {
                sendUsage(sender, subtypes[1]);
            }
        }
    }
    private void execute4Color(ICommandSender sender, EntityPlayerMP player, String rawr, String rawg, String rawb) throws PlayerNotFoundException
    {
        try
        {
            float r = Float.parseFloat(rawr) >= 1 ? 1 : Float.parseFloat(rawr);
            float g = Float.parseFloat(rawg) >= 1 ? 1 : Float.parseFloat(rawg);
            float b = Float.parseFloat(rawb) >= 1 ? 1 : Float.parseFloat(rawb);
            FogUtil.SetFogColor(player, r, g, b);
        }
        catch (NumberFormatException e)
        {
            sendUsage(sender, subtypes[0]);
        }
    }
    private void execute4Density(ICommandSender sender, EntityPlayerMP player, String rawd)
    {
        try
        {
            float d = Float.parseFloat(rawd);
            if (d > 0)
            {
                FogUtil.SetFogDensity(player, d >= 1 ? 1 : d);
            }
            else
            {
                FogUtil.SetFogDensity(player, 0);
            }
        }
        catch (NumberFormatException e)
        {
            sendUsage(sender, subtypes[1]);
        }
    }
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
    {
        if (args.length == 1)
        {
            return getListOfStringsMatchingLastWord(args, subtypes);
        }
        else
        {
            return Collections.emptyList();
        }
    }
}
