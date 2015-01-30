import java.util.*;

public class StableMarriage
{
	public static class SpousePreference
	{
		public String person;
		public List<String> ranked_preferences;
	}

	private static SpousePreference read_input_line(Scanner scan)
	{
		String line = scan.nextLine();
		SpousePreference to_return = new SpousePreference();

		String[] splitcolon = line.split(":");
		to_return.person = splitcolon[0];

		String[] splitcomma = splitcolon[1].split(",");

		to_return.ranked_preferences = new LinkedList<String>();
		for(int i=0; i<splitcomma.length; i++)
			to_return.ranked_preferences.add(splitcomma[i].trim());

		return to_return; 
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		HashMap<String, List<String> > men = new HashMap<String, List<String> >();
		HashMap<String, List<String> > women = new HashMap<String, List<String> >();

		Queue<String> bachelors = new LinkedList<String>();
		HashMap<String, String> w2m_engagements = new HashMap<String, String>();

		SpousePreference first_man = read_input_line(scan);
		int num_men = first_man.ranked_preferences.size();
		men.put(first_man.person, first_man.ranked_preferences);
		bachelors.add(first_man.person);

		for(int i=1; i<num_men; i++)
		{
			SpousePreference current_man = read_input_line(scan);
			men.put(current_man.person, current_man.ranked_preferences);
			bachelors.add(current_man.person);
		}

		for(int i=0; i<num_men; i++)
		{
			SpousePreference current_woman = read_input_line(scan);
			women.put(current_woman.person, current_woman.ranked_preferences);
		}

		//engage men
		while(bachelors.peek() != null)
		{
			String current_man = bachelors.remove();
			boolean guy_not_engaged = true; 
			while(guy_not_engaged)
			{
				String propose = men.get(current_man).remove(0);
				String woman_current_partner = w2m_engagements.get(propose);
				if(woman_current_partner == null || women.get(propose).indexOf(woman_current_partner) > women.get(propose).indexOf(current_man))
				{
					if(woman_current_partner != null)
						bachelors.add(woman_current_partner);
					w2m_engagements.put(propose, current_man);
					guy_not_engaged = false;
				}
			}
			
		}

		for(Iterator<Map.Entry<String, String> >i = w2m_engagements.entrySet().iterator(); i.hasNext();)
		{
			Map.Entry<String, String> i_val = i.next();
			System.out.println(i_val.getValue() + " / " + i_val.getKey());
		}

	}
}