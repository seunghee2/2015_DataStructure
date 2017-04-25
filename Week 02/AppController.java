public class AppController {
	private AppView _appView;
	private ArrayBag _coinCollector;

	public AppController() {
		this._appView = new AppView();
	}

	public void run() {
		int totalCoin = 0;
		int input = 0;
		int order = 0;

		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_InputTotalCoin);
		totalCoin = this._appView.inputInt();
		this._coinCollector = new ArrayBag(totalCoin);

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
						this._coinCollector.sumElementValue());
			} else if (order == 4) {
				this.showMessage(MessageID.Notice_InputCoin);
				input = this._appView.inputInt();
				Coin givenCoin = new Coin(input);
				this._appView.outputSearch(input,
						this._coinCollector.frequencyOf(givenCoin));
			} else if (order == 9) {
				this.showMessage(MessageID.Notice_EndMenu);
				this._appView.outputResult(this._coinCollector.size(),
						this._coinCollector.maxElementValue(),
						this._coinCollector.sumElementValue());
				this.showMessage(MessageID.Notice_EndProgram);
			} else
				this.showMessage(MessageID.Error_WrongMenu);
		}
	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			this._appView.outputMessage("<<���� ���� ���α׷��� �����մϴ�>>\n");
			break;
		case Notice_EndProgram:
			this._appView.outputMessage("<<���� ���� ���α׷��� �����մϴ�>>\n");
			break;
		case Notice_InputTotalCoin:
			this._appView.outputMessage("���濡 �� �� ���� ������ �Է��Ͻÿ� : ");
			break;
		case Notice_Menu:
			this._appView
					.outputMessage("�����Ϸ����ϴ� �޴��� �����ϼ���\n"
							+ "<add : 1, remove : 2, print : 3, search : 4, exit : 9) : ");
			break;
		case Notice_EndMenu:
			this._appView.outputMessage("9�� �ԷµǾ� �����մϴ�\n");
			break;
		case Notice_InputCoin:
			this._appView.outputMessage("������ �׼��� �Է��ϼ��� : ");
			break;
		case Error_WrongMenu:
			this._appView.outputMessage("<<ERROR : �߸��� �޴��Դϴ�.>>\n");
			break;
		default:
			break;
		}
	}

}
