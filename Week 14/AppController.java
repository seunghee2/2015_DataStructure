import java.util.Random;

public class AppController {
	private AppView _appView;
	HeapPriorityQueue<Integer> _priorityQueue;

	// SortedArrayPriorityQueue<Integer> _priorityQueue;

	// SortedLinkedPriorityQueue<Integer> _priorityQueue;

	public AppController() {
		this._appView = new AppView();
	}

	public void showAll() {
		if (this._priorityQueue.isEmpty())
			this.showMessage(MessageID.Error_Empty);
		else {
			this.showMessage(MessageID.Notice_ShowStart);
			HeapPriorityQueue.PriorityQueueIterator iterator = 
					(HeapPriorityQueue.PriorityQueueIterator) this._priorityQueue
					.priorityQueue();
			// SortedArrayPriorityQueue.PriorityQueueIterator iterator =
			// (SortedArrayPriorityQueue.PriorityQueueIterator)
			// this._priorityQueue
			// .priorityQueue();
			// SortedLinkedPriorityQueue.PriorityQueueIterator iterator =
			// (SortedLinkedPriorityQueue.PriorityQueueIterator)
			// this._priorityQueue
			// .priorityQueue();
			while (iterator.hasNext()) {
				this._appView.outputElement((Comparable) iterator.next());
			}
			System.out.println();
		}
	}

	public void run() {
		this._priorityQueue = new HeapPriorityQueue<Integer>();
		// this._priorityQueue = new SortedArrayPriorityQueue<Integer>();
		// this._priorityQueue = new SortedLinkedPriorityQueue<Integer>();
		char command = 0;
		int input;

		this.showMessage(MessageID.Notice_StartProgram);

		while (command != 'q') {
			this.showMessage(MessageID.Notice_Menu);
			command = this._appView.inputCharacter();
			if (command == 'i') {
				input = this._appView.inputNumber();
				this.add(input);
			} else if (command == 'r') {
				Random random = new Random();
				int i = 0;
				for (i = 0; i < 10; i++) {
					if (this._priorityQueue.isFull())
						break;
					else {
						Integer newData = (int) (Math.random() * 100);
						this.add(newData);
					}
				}
				System.out.println("- 임의의 원소가 " + i + " 개 입력되었습니다. ");
			} else if (command == 'v') {
				this.showAll();
			} else if (command == 'd') {
				this.removeMax();
			} else if (command == 'm') {
				this.maxValue();
			} else if (command == 'n') {
				this.showSize();
			} else if (command == 'x') {
				this.reset();
			} else if (command == 'q')
				this.showMessage(MessageID.Notice_EndProgram);
			else
				this.showMessage(MessageID.Error_WrongMenu);

		}
	}

	private void reset() {
		if (this._priorityQueue.isEmpty())
			this.showMessage(MessageID.Error_Empty);
		else {
			this.showMessage(MessageID.Notice_StartRemoveAll);
			for (int i = this._priorityQueue.size(); i > 0; i--) {
				this._appView.outputElement(this._priorityQueue.removeMax());
			}
			System.out.println();
			this.showMessage(MessageID.Notice_EndRemoveAll);
		}
	}

	private void showSize() {
		this._appView.outputSize(this._priorityQueue.size());
	}

	private void maxValue() {
		if (this._priorityQueue.isEmpty())
			this.showMessage(MessageID.Error_Empty);
		else
			this._appView.outputMaxValue((Integer) this._priorityQueue.max());
	}

	private void removeMax() {
		if (this._priorityQueue.isEmpty())
			this.showMessage(MessageID.Error_Empty);
		else
			this._appView.outputRemovedMax(this._priorityQueue.removeMax());
	}

	private void add(int input) {
		if (this._priorityQueue.isFull())
			this.showMessage(MessageID.Error_InputFull);
		else {
			this._priorityQueue.add(input);
			this._appView.outputAdd(input);

		}
	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println("<우선순위 큐를 시작합니다> ");
			break;
		case Notice_Menu:
			System.out.println();
			System.out.println("[다음 중 해야 할 일의 코드를 선택하시오]");
			System.out.println("i : 입력 ");
			System.out.println("m : 최대값 보기 ");
			System.out.println("d : 최대값 삭제 ");
			System.out.println("v : Priority Queue 내용 보기 ");
			System.out.println("x : 모든 원소 차례대로 삭제하여 출력 ");
			System.out.println("r : 난수를 생성하여 10개 입력 ");
			System.out.println("n : 원소의 개수 보기 ");
			System.out.println("q : 프로그램 종료 ");
			break;
		case Notice_EndProgram:
			System.out.println("<우선순위 큐가 끝났습니다> ");
			break;
		case Notice_ShowStart:
			System.out.println("= Priority Queue의 내용 =");
			break;
		case Notice_StartRemoveAll:
			System.out.println("= 삭제된 원소들 =");
			break;
		case Notice_EndRemoveAll:
			System.out.println("= 삭제 종료 - Priority Queue 비었습니다. ");
			break;
		case Error_WrongMenu:
			System.out.println("- Error : 잘못된 입력입니다.");
			break;
		case Error_InputFull:
			System.out.println("ERROR : Priority Queue가 꽉 차서 입력할 수 없습니다.");
			break;
		case Error_Empty:
			System.out.println("ERROR : Priority Queue는 비어있습니다.");
			break;
		default:
			break;
		}
	}
}
