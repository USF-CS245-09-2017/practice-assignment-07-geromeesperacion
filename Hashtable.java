/**
 * 
 * @author geromeesperacion
 *
 */

/*
 * creates a hashtable
 */
public class Hashtable {
	
	private HashNode[] table;
	
	//constructor
	public Hashtable(){
		table = new HashNode[45555];
	}
	
	/*
	 * returns the value associated with the key which is passed as an argument; 
	 * returns null if no key/value pair is contained by the Hashtable instance. 
	 */
	public String get(String key) {
		
		int pos = Math.abs(key.hashCode()) % table.length;
		HashNode start = table[pos];
		String result = null;
		
		while(start != null) {
			if(start.key.equals(key)) {
				result = start.value;
				return result;
			}
			
			start = start.next;
		}
		
		return result;
	}
	
	/*
	 * Adds the key/value pair into the Hashtable instance. If there is an existing key/value pair, 
	 * the Hashtable instance replaces the stored value with the argument value.
	 */
	public void put(String key, String value) {
		
		int pos = Math.abs(key.hashCode()) % table.length;	
		
		if (table[pos] == null) {
			table[pos] = new HashNode(key, value);
		} else {
			HashNode start = table[pos];
			
			if (start.key.equals(key)) {
				table[pos].value = value;
			}
			
			while ((start.next != null) && (start.next.key != key)) {
				start = start.next;
			}
			
			if (start.next != null) {
				start.next.value = value;
			}
			
			HashNode temp = new HashNode(key, value);
			start.next = temp;
		}

	}
	
	/*
	 * Removes the key/value pair from the Hashtable instance and returns the value associated with 
	 * the key to the caller. Throws an Exception instance if the key is not present in the 
	 * Hashtable instance.
	 */
	public String remove(String key) throws Exception {
		
		int pos = Math.abs(key.hashCode()) % table.length;
		HashNode start = table[pos];
		
		if(start.key.equals(key)) {
			table[pos] = start.next;
			return start.value;
		}
		
		while((start.next != null) && (start.next.key != key)) {
			start = start.next;
		}
		
		if(start.next != null) {
			start.next = start.next.next;
			return start.next.value;
		}
		
		throw new Exception("Key does not exist in the table.");
			
	}
	
	/*
	 * returns “true” if a key/value object pair (with the key matching the argument and any value). 
	 */
	public boolean containsKey(String key) {
		
		int pos = Math.abs(key.hashCode()) % table.length;
		boolean result = false;
		HashNode start = table[pos];
		
		while(start != null) {
			if(start.key.equals(key)) {
				result = true;
				return result;
			}
			
			start = start.next;
		}
		
		return result;
	}
	
}