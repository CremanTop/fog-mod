package creman.fog.commands;

import creman.fog.api.FogUtil;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FogCommand extends CommandBase
{
    @Override
    public String getName()
    {
        return "fog";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        String translation = "commands.fog.usage";
        sender.sendMessage(new TextComponentTranslation(translation));
        return translation;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String [] args)
    {
        if (args.length == 0)
        {
            getUsage(sender);
            return;
        }
        if (args[0].equals("color") && args.length == 4)
        {
            execute4Color(sender, args[1], args[2], args[3]);
            return;
        }
        if (args[0].equals("density") && args.length == 2)
        {
            execute4Density(sender, args[1]);
            return;
        }
        getUsage(sender);
    }
    private void execute4Color(ICommandSender sender, String rawr, String rawg, String rawb)
    {
        try
        {
            float r = Float.parseFloat(rawr) >= 1 ? 1 : Float.parseFloat(rawr);
            float g = Float.parseFloat(rawg) >= 1 ? 1 : Float.parseFloat(rawg);
            float b= Float.parseFloat(rawb) >= 1 ? 1 : Float.parseFloat(rawb);
            FogUtil.SetFogColor(r, g, b);
        }
        catch (NumberFormatException e)
        {
            getUsage(sender);
        }
    }
    private void execute4Density(ICommandSender sender, String rawd)
    {
        try
        {
            float d = Float.parseFloat(rawd);
            if (d > 0)
            {
                FogUtil.SetFogDensity(d >= 1 ? 1 : d);
            }
            else
            {
                getUsage(sender);
            }
        }
        catch (NumberFormatException e)
        {
            getUsage(sender);
        }
    }
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos)
    {
        if (args.length == 1)
        {
            String[] array = {"color", "density"};
            return getListOfStringsMatchingLastWord(args, array);
        }
        else
        {
            return Collections.emptyList();
        }
    }
}
