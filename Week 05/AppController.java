public class AppController {
	private AppView _appView;
	// private ArraySet _starCollector;
	private LinkedSet _starCollector;

	public AppController() {
		this._appView = new AppView();
	}

	private void input() {
		this.showMessage(MessageID.Notice_InputStar);
		this.showMessage(MessageID.Notice_InputStarXCoordinate);
		int xCoordinate = this._appView.inputInt();
		this.showMessage(MessageID.Notice_InputStarYCoordinate);
		int yCoordinate = this._appView.inputInt();
		this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		if (!this._starCollector.add(new Star(xCoordinate, yCoordinate,
				starName)))
			this.showMessage(MessageID.Error_Input);
	}

	private void remove() {
		this.showMessage(MessageID.Notice_RemoveStar);
		this.showMessage(MessageID.Notice_InputStarName);

		String starName = this._appView.inputString();

		Star removeStar = this._starCollector.remove(new Star(starName));

		if (removeStar == null)
			this.showMessage(MessageID.Error_Remove);
		else {
			System.out.println("X��ǥ : " + removeStar.xCoordinate());
			System.out.println("Y��ǥ : " + removeStar.yCoordinate());
			System.out.println("���� �̸� : " + removeStar.starName());
		}
	}

	private void searchByName() {
		this.showMessage(MessageID.Notice_SearchByName);
		this.showMessage(MessageID.Notice_InputStarName);
		String starName = this._appView.inputString();
		Star aStar = new Star(starName);

		if (this._starCollector.doesContain(aStar)) {
			this._appView.outputStarExistence(starName, 0, 0);
		} else {
			System.out.println("���ϴ� ���� �������� �ʽ��ϴ�.");
		}
	}

	private void searchByCoordinate() {
		this.showMessage(MessageID.Notice_SearchByCoordinate);
		this.showMessage(MessageID.Notice_InputStarXCoordinate);
		int xCoordinate = this._appView.inputInt();
		this.showMessage(MessageID.Notice_InputStarYCoordinate);
		int yCoordinate = this._appView.inputInt();

		Star aStar = new Star(xCoordinate, yCoordinate);

		if (this._starCollector.doesContain(aStar))
			this._appView.outputStarExistence(null, xCoordinate, yCoordinate);
		else {
			System.out.println("���ϴ� ���� �������� �ʽ��ϴ�.");
		}
	}

	public void run() {
		// this._starCollector = new ArraySet();
		this._starCollector = new LinkedSet();
		this.showMessage(MessageID.Notice_StartProgram);
		int command = 0;
		while (command != 9) {
			try {
				this.showMessage(MessageID.Notice_Menu);
				command = this._appView.inputInt();
				if (command == 1) {
					this.input();
				} else if (command == 2) {
					this.remove();
				} else if (command == 3) {
					this.showMessage(MessageID.Notice_RemoveRandomStar);
					Star removedStar = this._starCollector.removeAny();
					if (removedStar != null)
						this._appView.outputStar(removedStar.starName(),
								removedStar.xCoordinate(),
								removedStar.yCoordinate());
					else
						this.showMessage(MessageID.Error_Remove);
				} else if (command == 4) {
					this.showMessage(MessageID.Notice_Show);
					this._appView.outputNumOfStars(this._starCollector.size());

				} else if (command == 5) {
					this.searchByName();
				} else if (command == 6) {
					this.searchByCoordinate();
				} else if (command == 9) {
					this.showMessage(MessageID.Notice_EndMenu);
					this._appView.outputNumOfStars(this._starCollector.size());
					break;
				} else {
					this.showMessage(MessageID.Error_WrongMenu);
				}

			} catch (Exception ex) {
				System.out.println("ErrorMessage : " + ex.getMessage());
				continue;
			}
		}
		this.showMessage(MessageID.Notice_EndProgram);
	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			this._appView.outputMessage("< ���� ������ �����մϴ� >\n\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("< ���� ������ �����մϴ� >\n");
			break;
		case Notice_InputStar:
			this._appView.outputMessage("- [�Է�] -\n");
			break;
		case Notice_InputStarXCoordinate:
			this._appView.outputMessage("- x��ǥ�� �Է��Ͻÿ� : ");
			break;
		case Notice_InputStarYCoordinate:
			this._appView.outputMessage("- y��ǥ�� �Է��Ͻÿ� : ");
			break;
		case Notice_InputStarName:
			this._appView.outputMessage("- ���� �̸��� �Է��Ͻÿ� : ");
			break;

		case Notice_RemoveRandomStar:
			this._appView.outputMessage("- [������ �� ����] -\n");
			break;
		case Notice_RemoveStar:
			this._appView.outputMessage("- [�־��� �� ����] -\n");
			break;
		case Notice_Show:
			this._appView.outputMessage("- [���] -\n");
			break;
		case Notice_SearchByName:
			this._appView.outputMessage("- [�̸����� �˻�] -\n");
			break;
		case Notice_SearchByCoordinate:
			this._appView.outputMessage("- [��ǥ�� �˻�] -\n");
			break;

		case Notice_Menu:
			this._appView.outputMessage("1:�Է�	2:�־��� �� ����	3:������ �� ����\n"
					+ "4:���      5:�̸����� �˻�    6:��ǥ�� �˻�    9:����\n"
					+ "���ϴ� �޴��� �Է��ϼ��� : ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("9�� �ԷµǾ� �����մϴ�.\n");
			break;
		case Error_Input:
			this._appView.outputMessage("ERROR : �߸��� �Է��Դϴ�.\n ");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("ERROR : �߸��� �Է��Դϴ�.\n");
			break;
		case Error_Remove:
			this._appView.outputMessage("ERROR : �߸��� �����Դϴ�.\n");
		default:
			break;
		}
	}
}
