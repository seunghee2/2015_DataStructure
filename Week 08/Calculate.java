public class Calculate {
	private ArrayList<Character> _oStack;
	private ArrayList<Double> _vStack;
	private char[] _infix;
	private char[] _postfix;

	public Calculate() {
		this._infix = null;
		this._oStack = null;
		this._postfix = null;
		this._vStack = null;
	}

	public void setInfix(String anInfix) {
		this._infix = anInfix.toCharArray();
	}

	public String infix() {
		if (this._infix != null)
			return String.valueOf(this._infix);
		else
			return null;
	}

	public String postfix() {
		if (this._postfix != null)
			return String.valueOf(this._postfix);
		else
			return null;
	}

	private boolean isDigit(char aToken) {
		return (aToken >= '0' && aToken <= '9');
	}

	public void showOStackAll() {
		System.out.print("OStack : ");
		for (int i = 0; i < this._oStack.size(); i++)
			System.out.print(this._oStack.elementAt(i) + " ");
		System.out.println();
	}

	public void showVStackAll() {
		System.out.print("VStack : ");
		for (int i = 0; i < this._vStack.size(); i++)
			System.out.print(this._vStack.elementAt(i) + " ");
		System.out.println();
	}

	public boolean infixToPostfix() {
		int i = 0, p = 0;
		char currentToken, poppedToken, topToken;

		this._oStack = new ArrayList<Character>(this._infix.length);
		this._postfix = new char[this._infix.length];

		while (i < this._infix.length) {
			currentToken = this._infix[i++];
			if (this.isDigit(currentToken))
				this._postfix[p++] = currentToken;
			else {
				if (currentToken == ')') {
					if (!this._oStack.isEmpty())
						poppedToken = (char) this._oStack.pop();
					else
						return false;
					while (poppedToken != '(') {
						this._postfix[p++] = poppedToken;
						if (!this._oStack.isEmpty())
							poppedToken = (char) this._oStack.pop();
						else
							return false;
					}
					this.showOStackAll();
				} else {
					int inComingP = this.inComingPrecedence(currentToken);
					if (!this._oStack.isEmpty()) {
						topToken = (char) this._oStack.peek();
						while (this.inStackPrecedence(topToken) >= inComingP) {
							poppedToken = (char) this._oStack.pop();
							this._postfix[p++] = poppedToken;
							if (!this._oStack.isEmpty())
								topToken = (char) this._oStack.peek();
							else
								break;

						}
					}
					this._oStack.push(currentToken);
					this.showOStackAll();
				}
			}

		}
		while (!this._oStack.isEmpty()) {
			poppedToken = (char) this._oStack.pop();
			this._postfix[p++] = poppedToken;
		}
		return true;
	}

	public double evalPostfix() {
		int p;
		char curToken;
		this._vStack = new ArrayList<Double>(this._infix.length);

		p = 0;
		while (p < this._postfix.length) {
			curToken = this._postfix[p++];
			if (this.isDigit(curToken)) {
				this._vStack.push(Double.parseDouble(String.valueOf(curToken)));
				this.showVStackAll();
			} else {
				double operand1 = this._vStack.pop();
				double result = 1;

				if (curToken == '+') {
					double operand2 = this._vStack.pop();
					result = operand1 + operand2;
				} else if (curToken == '-') {
					double operand2 = this._vStack.pop();
					result = operand2 - operand1;
				} else if (curToken == '*') {
					double operand2 = this._vStack.pop();
					result = operand1 * operand2;
				} else if (curToken == '/') {
					double operand2 = this._vStack.pop();
					result = operand2 / operand1;
				} else if (curToken == '%') {
					double operand2 = this._vStack.pop();
					result = operand2 % operand1;
				} else if (curToken == '^') {
					double operand2 = this._vStack.pop();
					for (int i = 0; i < operand1; i++)
						result *= operand2;
				} else {
					this._vStack.push(operand1);
					return this._vStack.peek();
				}
				this._vStack.push(result);
				this.showVStackAll();
			}
		}
		return this._vStack.peek();
	}

	private int inComingPrecedence(char aToken) {
		if (aToken == '+')
			return 12;
		else if (aToken == '-')
			return 12;
		else if (aToken == '(')
			return 20;
		else if (aToken == ')')
			return 19;
		else if (aToken == '*')
			return 13;
		else if (aToken == '/')
			return 13;
		else if (aToken == '%')
			return 13;
		else if (aToken == '^')
			return 17;
		else if (aToken == '$')
			return 0;
		else
			return -1;
	}

	private int inStackPrecedence(char aToken) {
		if (aToken == '+')
			return 12;
		else if (aToken == '-')
			return 12;
		else if (aToken == '(')
			return 0;
		else if (aToken == ')')
			return 19;
		else if (aToken == '*')
			return 13;
		else if (aToken == '/')
			return 13;
		else if (aToken == '%')
			return 13;
		else if (aToken == '^')
			return 16;
		else if (aToken == '$')
			return 0;
		else
			return -1;
	}

}
