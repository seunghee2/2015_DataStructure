public class AppController {
	private AppView _appView;
	private SortedLinkedList<Integer> _sortedList;

	// private SortedArrayList<Integer> _sortedList;

	public AppController() {
		this._appView = new AppView();
	}

	public void showSize() {
		this._appView.outputSize(this._sortedList.size());
	}

	public void reset() {
		this._sortedList.clear();
		this.showMessage(MessageID.Notice_Reset);
	}

	public void showAll() {
		this.showMessage(MessageID.Notice_ShowStartList);
		SortedLinkedList.ListIterator list = (SortedLinkedList.ListIterator) this._sortedList
				.listIterator();

		// SortedArrayList.ListIterator list = (SortedArrayList.ListIterator)
		// this._sortedList
		// .listIterator();

		while (list.hasNext()) {
			this._appView.outputElement((Comparable) list.next());

		}
		this.showMessage(MessageID.Notice_ShowEndList);

	}

	public void add(int inputValue) {
		Integer input = inputValue;
		if (this._sortedList.add(input))
			this._appView.outputAdd(input);
		else
			this.showMessage(MessageID.Error_WrongMenu);
	}

	public void removeMin() {
		this._appView.outputRemove((Integer) this._sortedList.removeMin());
	}

	public void removeMax() {
		this._appView.outputRemove((Integer) this._sortedList.removeMax());
	}

	public void removeFrom(int aPosition) {
		this._appView.outputRemove((Integer) this._sortedList.removeFrom(aPosition));
	}

	public void run() {
		this._sortedList = new SortedLinkedList<Integer>();
		// this._sortedList = new SortedArrayList<Integer>();
		char command = 0;
		int input;

		this.showMessage(MessageID.Notice_StartProgram);
		while (command != '!') {
			command = this._appView.inputCharacter();
			if (command == '%') {
				input = this._appView.inputNumber();
				this.add(input);
			} else if (command == '~')
				this.reset();
			else if (command == '-')
				this.removeMin();
			else if (command == '+')
				this.removeMax();
			else if (command == '#')
				this.showSize();
			else if (command == '?') {
				input = this._appView.inputNumber();
				this.removeFrom(input);
			} else if (command == '/')
				this.showAll();
			else if (command == '!')
				break;
			else
				this.showMessage(MessageID.Error_WrongMenu);

		}
		this.showMessage(MessageID.Notice_EndProgram);

	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println("<리스트를 시작합니다>");
			break;
		case Error_WrongMenu:
			System.out.println("[Error] 잘못된 입력입니다.");
			break;
		case Notice_EndProgram:
			System.out.println("<리스트가 끝났습니다>");
			break;
		case Notice_ShowStartList:
			System.out.print("[LIST] ");
			break;
		case Notice_Reset:
			System.out.println("- 리스트를 비웠습니다.");
			break;
		case Notice_ShowEndList:
			System.out.println("");
			break;
		case Error_InputFull:
			System.out.println("[Error] 리스트가 가득 차 있습니다.");
			break;
		case Error_Empty:
			System.out.println("[Error] 리스트가 비어있습니다.");
			break;
		default:
			break;
		}
	}
}
