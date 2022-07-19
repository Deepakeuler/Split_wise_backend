package Models;

import java.util.*;

public class SplitWise {

	private HashMap<String, User> all_users = new HashMap<>();

	public SplitWise() {

	}

	public User add_user(String name, String number, char gender) {
		String generate_id = name + number;
		User new_user = add_user(generate_id, name, number, gender);
		return new_user;
	}

	private User add_user(String user_id, String name, String number, char gender) {
		User new_user;
		if (all_users.containsKey(user_id)) {
			System.out.println("User already exists.");
			new_user = all_users.get(user_id);
		} else {
			new_user = new User(user_id, name, number, gender);
			all_users.put(user_id, new_user);
		}
		return new_user;
	}

	/*
	 * if distribution = 0 - equal if distribution = 1 - exact if distribution = 2 -
	 * percent
	 */

	public void make_transaction(User payee, int amount, User[] users, int distribution, int[] distrbutionStrat) {

		if (distribution == 0) {
			make_equal_transaction(payee, amount, users, distribution);

		} else if (distribution == 1) {
			make_exact_transaction(payee, amount, users, distribution, distrbutionStrat);

		} else {
			make_percent_transaction(payee, amount, users, distribution, distrbutionStrat);

		}
		
		for(int i = 0; i < users.length; i++) {
			System.out.println(users[i].owes);
		}
		
	}

	private void make_equal_transaction(User payee, int amount, User[] users, int distribution) {
		/*
		 * u1, 1000, [u2, u3, u4]
		 */

		int total_users = users.length;
		int amount_to_be_divided = amount / total_users;

		for (int i = 0; i < users.length; i++) {
			if(payee.getUser_id().equals(users[i].getUser_id()))continue;
			
			User current_user = users[i];

			// case1: u2 pehli baar u1 ko pese owe karta hai

			if (!current_user.owes.containsKey(payee)) {
				current_user.owes.put(payee, amount_to_be_divided);

			} else {
				// case2: u2 doosri ya teesir baar u1 ko pesse owe karta hai.
				int new_amount = amount_to_be_divided + current_user.owes.get(payee);
				current_user.owes.put(current_user, new_amount);

			}
		}
		
		

	}

	private void make_exact_transaction(User payee, int amount, User[] users, int distribution,
			int[] distribution_strat) {
		// TODO Auto-generated method stub
		/*
		 * Input: u1 1250 2 u2 u3 EXACT 370 880

		 */

		
		for (int i = 0; i < users.length; i++) {

			User current_user = users[i];
			int amount_owee_owes = distribution_strat[i];

			if (!current_user.owes.containsKey(payee)) {
				current_user.owes.put(payee, amount_owee_owes);
			} else {
				int revised_owed_amount = current_user.owes.get(payee) + amount_owee_owes;
				current_user.owes.put(payee, revised_owed_amount);
			}
		}

	}

	private void make_percent_transaction(User payee, int amount, User[] users, int distribution,
			int[] distrbution_strat) {

		/*
		 * Input: u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
		 * 
		 */
		amount /= 100;
		for(int i = 0; i<users.length; i++) {
			if(payee.getUser_id().equals(users[i].getUser_id()))continue;
			else{
				User current_user = users[i];
				int percentange_it_owes = (amount)*distrbution_strat[i];
				if(!current_user.owes.containsKey(payee)) {
					current_user.owes.put(payee,percentange_it_owes);
				}else {
					int revised_amount = current_user.owes.get(payee)+((amount)*distrbution_strat[i]);
					current_user.owes.put(payee, revised_amount);
				}
			}
		}
		
	

	}

}
