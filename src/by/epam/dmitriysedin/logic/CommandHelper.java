package by.epam.dmitriysedin.logic;

import java.util.HashMap;
import java.util.Map;

import by.epam.dmitriysedin.logic.impl.FirstPage;
import by.epam.dmitriysedin.logic.impl.NextPage;
import by.epam.dmitriysedin.logic.impl.PreviousPage;

public final class CommandHelper {

	private static final CommandHelper instance = new CommandHelper();

	private Map<CommandName, ICommand> commands = new HashMap<>();

	private CommandHelper() {

		commands.put(CommandName.SAX, new FirstPage());
		commands.put(CommandName.STAX, new FirstPage());
		commands.put(CommandName.DOM, new FirstPage());
		commands.put(CommandName.NEXT, new NextPage());
		commands.put(CommandName.PREVIOUS, new PreviousPage());
	}

	public static CommandHelper getInstance() {
		return instance;
	}

	public ICommand getCommand(String commandName) {

		CommandName name = CommandName.valueOf(commandName);

		ICommand command;

		if (name != null) {
			command = commands.get(name);
		} else {
			command = commands.get(CommandName.NO_SUCH_COMMAND);
		}

		return command;
	}
}
