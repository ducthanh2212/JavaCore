package genericsPackage;

import java.util.Iterator;

public class GenericList <T> implements Iterable<T>{
	private T[] items = (T[]) new Object[10];
	private int count;
	
	public void add(T item) {
		items[count++] = item;
	}
	
	public T get(int count) {
		return items[count];
	}

	

	@Override
	public Iterator<T> iterator() {
		
		return new ListIteratorCustom(this);
	}
	
	private class ListIteratorCustom implements Iterator<T>{

		private GenericList<T> lst;
		private int index;
		
		public ListIteratorCustom(GenericList<T> lst) {
			this.lst = lst;
		}
		
		@Override
		public boolean hasNext() {
			return (index < lst.items.length);
		}

		@Override
		public T next() {
			
			return lst.items[index];
		}
		
	}
	
}


