package Driver;

import Models.SplitWise;
import Models.User;

public class Main {
	
	public static void main(String[] args) {
		SplitWise sp = new SplitWise();
		User u1 = sp.add_user("name", "number", 'F');
		User u2 = sp.add_user("puru", "number", 'F');
		User u3 = sp.add_user("deepak", "number", 'F');
		User u4 = sp.add_user("ram", "number", 'F');
		
		User inpArray[] = {u1,u2,u3,u4};
		sp.make_transaction(u1, 1000, inpArray, 0, new int[0]);
		
		

	}
}
