public class Coin {
	private long _value;

	public Coin() {
		this._value = 0;
	}

	public Coin(long aValue) {
		this._value = aValue;
	}

	public long value() {
		return this._value;
	}

	public void setValue(long aValue) {
		this._value = aValue;
	}

	public boolean equals(Coin aCoin) {
		if (this._value == aCoin._value)
			return true;
		else
			return false;
	}

}
