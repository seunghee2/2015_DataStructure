public class AppController<T> {
	private AppView _appView;
	private int _inputChars;
	private int _ignoredChars;
	private int _addedChars;
	private ArrayList<Character> _arrayStack = new ArrayList<Character>();;

	public AppController() {
		this._appView = new AppView();
		this._inputChars = 0;
		this._ignoredChars = 0;
		this._addedChars = 0;
	}

	private void showAllFromBottom() {

		this.showMessage(MessageID.Show_StartBottom);
		for (int i = 0; i < this._arrayStack.size(); i++)
			this._appView.outputStackElement((char) this._arrayStack
					.elementAt(i));
		this.showMessage(MessageID.Show_EndTop);
	}

	private void showAllFromTop() {
		this.showMessage(MessageID.Show_StartTop);
		for (int i = 0; i < this._arrayStack.size() - 1; i++)
			this._appView.outputStackElement((char) this._arrayStack
					.elementAt(this._arrayStack.size() - i - 1));
		this.showMessage(MessageID.Show_EndTop);
	}

	private void showTopElement() {
		char topElement = (char) this._arrayStack.peek();
		this._appView.outputTopElement(topElement);
	}

	private void showStackSize() {
		this._appView.outputStackSize(this._arrayStack.size());

	}

	private void countAdded() {
		this._addedChars++;

	}

	private void countIgnored() {
		this._ignoredChars++;
	}

	private void countInputChar() {
		this._inputChars++;
	}

	@SuppressWarnings("unchecked")
	private void addToSteck(char inputChar) {
		if (this._arrayStack.push(inputChar)) {
			this._appView.outputAddedElement(inputChar);
			this.countAdded();
		} else
			this.showMessage(MessageID.Error_InputFull);
	}

	private void removeOne() {
		if (this._arrayStack.isEmpty())
			this.showMessage(MessageID.Error_RemoveEmpty);
		else {
			char c = (char) this._arrayStack.pop();
			this._appView.outputRemove(c);
		}

	}

	private void remoneN(int numOfCharsToBeRemoved) {
		this._appView.outputRemoveN(numOfCharsToBeRemoved);
		for (int i = 0; i < numOfCharsToBeRemoved; i++)
			this.removeOne();

	}

	private void conclusion() {
		for (int i = this._arrayStack.size() - 1; i > -1; i--)
			this._arrayStack.pop();
		this._appView.outputResult(this._inputChars, this._ignoredChars,
				this._addedChars);

	}

	public void run() {
		this._arrayStack = new ArrayList<Character>();
		char input;

		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		input = this._appView.inputCharacter();

		while (input != '!') {
			this.countInputChar();
			if ((input >= 'A' && input <= 'Z')
					|| (input >= 'a' && input <= 'z'))
				this.addToSteck(input);
			else if (input >= '0' && input <= '9')
				this.remoneN((int) (input - '0'));
			else if (input == '-')
				this.removeOne();
			else if (input == '#')
				this.showStackSize();
			else if (input == '/')
				this.showAllFromBottom();
			else if (input == '\\')
				this.showAllFromTop();
			else if (input == '^')
				this.showTopElement();
			else {
				this.showMessage(MessageID.Error_WrongMenu);
				this.countIgnored();
			}
			input = this._appView.inputCharacter();
		}
		this.showMessage(MessageID.Notice_EndMenu);
		this.conclusion();
		this.showMessage(MessageID.Notice_EndProgram);
	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println(">프로그램을 시작합니다.");
			break;
		case Notice_EndProgram:
			System.out.println(">프로그램을 종료합니다.");
			break;
		case Notice_StartMenu:
			System.out.println("[스택 사용을 시작합니다.]");
			break;
		case Notice_EndMenu:
			System.out.println("[스택 사용을 종료합니다.]");
			break;
		case Notice_InputStack:
			System.out.print("- 문자를 입력하시오 : ");
			break;
		case Show_StartBottom:
			System.out.print("[Stack] <Bottom> ");
			break;
		case Show_StartTop:
			System.out.print("[Stack] <Top>");
			break;
		case Show_EndBottom:
			System.out.println(" <Bottom>");
			break;
		case Show_EndTop:
			System.out.println(" <Top>");
			break;
		case Error_WrongMenu:
			System.out.println("[Error] 의미 없는 문자가 입력되었습니다.");
			break;
		case Error_InputFull:
			System.out.println("[Full] 스택이 꽉 차서 삽입이 불가능합니다.");
			break;
		case Error_RemoveEmpty:
			System.out.println("[Empty] 스택에 삭제할 원소가 없습니다.");
			break;
		}
	}
}
