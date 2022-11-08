package creman.fog.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static creman.fog.api.FogUtil.SetFogDensity;
import static creman.fog.api.FogUtil.SetFogColor;

public class FogCommand extends CommandBase
{
    @Override
    public String getName()
    {
        return "fog";
    }

    @Override
    public String getUsage(@NotNull ICommandSender sender)
    {
        return "commands.fog.usage";
    }

    @Override
    public void execute(@NotNull MinecraftServer server, @NotNull ICommandSender sender, String @NotNull [] args) throws CommandException
    {
        if (args.length == 0)
        {
            getUsage(sender);
            return;
        }
        if (Objects.equals(args[0], "color"))
        {
            try
            {
                SetFogColor (Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            }
            catch (NumberFormatException e)
            {
                getUsage(sender);
            }
        }
        if (Objects.equals(args[0], "density"))
        {
            try
            {
                if (Float.parseFloat(args[1]) > 0)
                {
                    SetFogDensity(Float.parseFloat(args[1]));
                }
            }
            catch (NumberFormatException e)
            {
//                sender.sendMessage((ITextComponent)new TextComponentString("Error " + args[0] + " or " + args[1] + " or " + args[2] + " or " + args[3]));
//                sender.sendMessage((ITextComponent)TextComponentHelper.createComponentTranslation(sender, getUsage(sender), new Object[0]));
                getUsage(sender);
            }
        }
    }

    @Override
    public List<String> getTabCompletions(@NotNull MinecraftServer server, @NotNull ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
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
