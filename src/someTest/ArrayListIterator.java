package someTest;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIterator<T> implements Iterator<T>{

	ArrayList<T> list;
	int position;
	
	ArrayListIterator(ArrayList<T> al) {
		this.list = al;
		position = 0;
	}
	


	@Override
	public boolean hasNext()
	{
		return list != null && position < list.size();
	}

	@Override
	public T next()
	{
		if (!hasNext()) {
			return null;
		}
		return list.get(position++);
	}

	@Override
	public void remove()
	{
		if (!hasNext()) {
			return;
		}
		list.remove(position);
	}
	
	public static void main(String[] args){
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		ArrayListIterator<Integer> ai = new ArrayListIterator<Integer>(al);
		System.out.println(ai.next());
		System.out.println(ai.next());
		ai.remove();
		System.out.println(ai.next());
		System.out.println(ai.next());
	}
}
