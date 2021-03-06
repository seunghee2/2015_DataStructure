public class AppController {
	private AppView _appView;
	private LinkedBag _coinCollector;

	public AppController() {
		this._appView = new AppView();
	}

	public void run() {

		int input = 0;
		int order = 0;

		this.showMessage(MessageID.Notice_StartProgram);

		this._coinCollector = new LinkedBag();

		while (order != 9) {
			this.showMessage(MessageID.Notice_Menu);
			order = this._appView.inputInt();
			if (order == 1) {
				this.showMessage(MessageID.Notice_InputCoin);
				input = _appView.inputInt();
				Coin anCoin = new Coin(input);
				this._coinCollector.add(anCoin);
			} else if (order == 2) {
				this.showMessage(MessageID.Notice_InputCoin);
				input = this._appView.inputInt();
				Coin givenCoin = new Coin(input);
				this._coinCollector.remove(givenCoin);
			} else if (order == 3) {
				this._appView.outputResult(this._coinCollector.size(),
						this._coinCollector.maxElementValue(),
						this._coinCollector.sumElementValues());
			} else if (order == 4) {
				this.showMessage(MessageID.Notice_InputCoin);
				input = this._appView.inputInt();
				Coin givenCoin = new Coin(input);
				this._appView.outputSearch(input,
						this._coinCollector.frequencyOf(givenCoin));
			} else if (order == 5) {
				Coin removeCoin = new Coin();
				removeCoin = this._coinCollector.removeAny();
				this._appView.outputRemove(removeCoin.value());
			} else if (order == 9) {
				this.showMessage(MessageID.Notice_EndMenu);
				this._appView.outputResult(this._coinCollector.size(),
						this._coinCollector.maxElementValue(),
						this._coinCollector.sumElementValues());
				this.showMessage(MessageID.Notice_EndProgram);
			} else
				this.showMessage(MessageID.Error_WrongMenu);
		}
	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			this._appView.outputMessage("<<동전 가방 프로그램을 시작합니다>>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("<<동전 가방 프로그램을 종료합니다>>\n");
			break;
		case Notice_InputTotalCoin:
			this._appView.outputMessage("가방에 들어갈 총 코인 개수를 입력하시오 : ");
			break;
		case Notice_Menu:
			this._appView
					.outputMessage("수행하려고하는 메뉴를 선택하세요\n"
							+ "<add : 1, remove : 2, print : 3, search : 4,removeAny : 5, exit : 9) : ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("9가 입력되어 종료합니다\n");
			break;
		case Notice_InputCoin:
			this._appView.outputMessage("코인의 액수를 입력하세요 : ");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("<<ERROR : 잘못된 메뉴입니다.>>\n");
			break;
		default:
			break;
		}
	}

}
