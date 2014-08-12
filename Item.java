import a2.A2Item;

public class Item implements A2Item {

	private String performer;
	private double transactionValue;
	private String date;

	public Item() {
		// ...
	}

	public Item(String name, double value, String date) {
		this.performer = name;
		this.transactionValue = value;
		this.date = date;
	}

	public String getPerformer() {
		return this.performer;
	}
	public double getTransactionValue() {
		return this.transactionValue;
	}
	public String getDate() {
		return this.date;
	}
	
	public void setPerformer(String name) {
		this.performer = name;
	}
	public void setTransactionValue(double value) {
		this.transactionValue = value;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		int hash = 17;  // start with prime number
		int performerLength = this.performer.length();  // string length of performer name
		for (int i=0; i<performerLength; i++) {
			// 31 is suppose to be a good hashcode prime for Java.
			// add each letter number in performers name
			hash = hash * 31 + this.performer.charAt(i);
		}		
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Item)) {
			return false;
		}
		return this.performer.equals(((Item)obj).performer);
	}
}