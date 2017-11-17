/**
 * 
 * @author geromeesperacion
 *
 */

/*
 * Creates a node for use in a hash table
 */
public class HashNode {

	protected String key;
	protected String value;
	HashNode next;
	
	//constructor
	public HashNode (String key, String value) {
		this.key = key;
		this.value = value;
		next = null;
	}

}
