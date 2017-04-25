public class AppController<T> {
	private AppView _appView;
	private LinkedQueue _linkedQueue;
	private int _inputChars;
	private int _ignoredChars;
	private int _addedChars;

	public AppController() {
		this._appView = new AppView();
		this.initCharCounts();
	}

	public void showFrontElement() {
		this._appView.outputFrontElement((Character) this._linkedQueue
				.frontElement());
	}

	public void showQueueSize() {
		this._appView.outputQueueSize(this._linkedQueue.size());

	}

	public void showAll() {
		this.showMessage(MessageID.Show_QueueStart);
		for (int i = 0; i < this._linkedQueue.size(); i++)
			this._appView.outputElement((Character) this._linkedQueue
					.elementAt(i));
		this.showMessage(MessageID.Show_QueueEnd);
	}

	public void initCharCounts() {
		this._inputChars = 0;
		this._addedChars = 0;
		this._ignoredChars = 0;
	}

	public void countAdded() {
		this._addedChars++;
	}

	public void countIgnored() {
		this._ignoredChars++;
	}

	public void countInputChar() {
		this._inputChars++;
	}

	@SuppressWarnings("unchecked")
	public void add(char c) {
		if (this._linkedQueue.isFull())
			this.showMessage(MessageID.Error_InputFull);
		else {
			if (this._linkedQueue.enQueue(c)) {
				this._appView.outputAdd(c);
				this.countAdded();
			}
		}

	}

	public void removeOne() {
		if (!this._linkedQueue.isEmpty()) {
			char removed = (char) (Character) this._linkedQueue.deQueue();
			this._appView.outputRemove(removed);
		}

		else
			this.showMessage(MessageID.Error_Empty);
	}

	public void removeN(int numOfCharsToBeDeleted) {
		this._appView.outputRemoveN(numOfCharsToBeDeleted);
		for (int i = 0; i < numOfCharsToBeDeleted; i++)
			this.removeOne();

	}

	public void conclusion() {
		for (int i = this._linkedQueue.size() - 1; i > -1; i--)
			this.removeOne();
		this._appView.outputResult(this._inputChars, this._ignoredChars,
				this._addedChars);

	}

	public void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println("> 프로그램을 시작합니다.");
			break;
		case Notice_StartMenu:
			System.out.println("[ 큐 입력을 시작합니다. ]");
			break;
		case Notice_EndProgram:
			System.out.println("> 프로그램을 종료합니다.");
			break;
		case Notice_EndMenu:
			System.out.println("[ 큐 입력을 종료합니다. ]");
			break;
		case Error_InputFull:
			System.out.println("Error : 큐가 꽉 차서 삽입이 불가능 합니다.");
			break;
		case Error_Empty:
			System.out.println("[Empty] 큐에 원소가 없습니다. ");
			break;
		case Show_QueueStart:
			System.out.print("[Queue]  <Front> ");
			break;
		case Show_QueueEnd:
			System.out.println(" <Rear>");
			break;
		default:
			System.out.println("Error : 의미 없는 문자가 입력되었습니다.");
		}
	}

	public void run() {
		this._linkedQueue = new LinkedQueue<Character>();
		char input;

		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);

		input = this._appView.inputCharacter();
		while (input != '!') {
			this.countInputChar();
			if ((input >= 'A' && input <= 'Z')
					|| (input >= 'a' && input <= 'z'))
				this.add(input);
			else if (input >= '0' && input <= '9')
				this.removeN(Integer.parseInt(String.valueOf(input)));
			else if (input == '-')
				this.removeOne();
			else if (input == '#')
				this.showQueueSize();
			else if (input == '/')
				this.showAll();
			else if (input == '^')
				this.showFrontElement();
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
}
