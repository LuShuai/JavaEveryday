package trees;
import java.util.HashSet;
/*
 * Suppose you have a tree shows the HR status of a company.
 * Find all leaders that have at least one sub-employee who is in a different department.  
 * 
 * 				A1
			    / \
			  B1   C2
			 / \
			D3  E1
{A,B} in this case
 * 
 */


public class TreeDept
{
	class Person {
		int dept;
		char name;
		HashSet<Person> sub;
		Person (char n, int d) {
			dept = d;
			name = n;
			sub = new HashSet<Person>();
		}
	}
	
	//build a HR structure
	public Person build(){
		//get person
		Person pA = new Person('A', 1);
		Person pB = new Person('B', 1);
		Person pC = new Person('C', 2);
		Person pD = new Person('D', 3);
		Person pE = new Person('E', 1);
		//recruit
		pA.sub.add(pB);
		pA.sub.add(pC);
		pB.sub.add(pD);
		pB.sub.add(pE);
		return pA;
	}

	
	public HashSet<Person> get(Person root) {
		HashSet<Person> res = new HashSet<Person>();
		getHelper(root, res);
		return res;
	}
	
	private boolean getHelper(Person root, HashSet<Person> res) {
		
		if (root == null) {
			System.out.println("null");
			return true;
		}
		System.out.println("check: " + root.name);

		//level 0 employees
		/*
		if (root.sub.size() == 0) {
			System.out.println(root.name +" has no sub");
			return true;
		}
		*/
		boolean qualify = true;
		for (Person subEmp : root.sub) {
			if ( getHelper(subEmp, res) == false || subEmp.dept != root.dept) {
				res.add(root);
				qualify = false;
			}
		}
		return qualify;
	}
	
	
	public static void main(String[] args)
	{
		TreeDept self = new TreeDept();
		Person CEO = self.build();
		//should be A, B
		for(Person p : self.get(CEO)) {
			System.out.println(p.name);
		}
	}
}
