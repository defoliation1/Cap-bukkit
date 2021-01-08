package engine.command.argument;

import engine.command.CommandSender;

public interface SenderArgument {

    CommandSender getSender();

    void setSender(CommandSender sender);

}
