import java.util.LinkedList;
import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter
{
	private LinkedList<String> ducks;
	private Random r;
	
	public CommandListener()
	{
		ducks = new LinkedList<String>();
		DataHandler.addToList(ducks, "ducks.txt", null);
		
		r = new Random();
	}
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e)
	{		
		if(e.getMessage().getContentRaw().equalsIgnoreCase("sadbois"))
		{
				EmbedBuilder eb = new EmbedBuilder();
				eb.setDescription("Here is your fabulous duck!");
				String url = ducks.get(r.nextInt(ducks.size()));
				eb.setImage(url);
				
				e.getChannel().sendMessage(eb.build()).queue();
		}
		
		if(e.getMessage().getContentRaw().equalsIgnoreCase("happybois") && e.getAuthor().getId().equals("475859944101380106"))
		{
			MainBot.jda.shutdown();
			System.exit(0);
		}
		
	}
}
