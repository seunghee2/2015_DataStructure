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
			System.out.println("X좌표 : " + removeStar.xCoordinate());
			System.out.println("Y좌표 : " + removeStar.yCoordinate());
			System.out.println("별의 이름 : " + removeStar.starName());
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
			System.out.println("원하는 별이 존재하지 않습니다.");
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
			System.out.println("원하는 별이 존재하지 않습니다.");
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
			this._appView.outputMessage("< 별의 집합을 시작합니다 >\n\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("< 별의 집합을 종료합니다 >\n");
			break;
		case Notice_InputStar:
			this._appView.outputMessage("- [입력] -\n");
			break;
		case Notice_InputStarXCoordinate:
			this._appView.outputMessage("- x좌표를 입력하시오 : ");
			break;
		case Notice_InputStarYCoordinate:
			this._appView.outputMessage("- y좌표를 입력하시오 : ");
			break;
		case Notice_InputStarName:
			this._appView.outputMessage("- 별의 이름을 입력하시오 : ");
			break;

		case Notice_RemoveRandomStar:
			this._appView.outputMessage("- [임의의 별 삭제] -\n");
			break;
		case Notice_RemoveStar:
			this._appView.outputMessage("- [주어진 별 삭제] -\n");
			break;
		case Notice_Show:
			this._appView.outputMessage("- [출력] -\n");
			break;
		case Notice_SearchByName:
			this._appView.outputMessage("- [이름으로 검색] -\n");
			break;
		case Notice_SearchByCoordinate:
			this._appView.outputMessage("- [좌표로 검색] -\n");
			break;

		case Notice_Menu:
			this._appView.outputMessage("1:입력	2:주어진 별 삭제	3:임의의 별 삭제\n"
					+ "4:출력      5:이름으로 검색    6:좌표로 검색    9:종료\n"
					+ "원하는 메뉴를 입력하세요 : ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("9가 입력되어 종료합니다.\n");
			break;
		case Error_Input:
			this._appView.outputMessage("ERROR : 잘못된 입력입니다.\n ");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("ERROR : 잘못된 입력입니다.\n");
			break;
		case Error_Remove:
			this._appView.outputMessage("ERROR : 잘못된 제거입니다.\n");
		default:
			break;
		}
	}
}
