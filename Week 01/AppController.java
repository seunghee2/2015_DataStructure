public class AppController {
	private AppView _appView;
	private MagicSquare _magicSquare;
	private Board _board;

	public AppController() {
		this._appView = new AppView();
		this._magicSquare = new MagicSquare();
	}

	public void run() {
		this.showMessage(MessageID.Notice_BeginMagicSquare);
		OrderValidity currentOrderValidity;

		int order = this._appView.inputOrder();

		while (order > 0) {
			currentOrderValidity = this._magicSquare.checkOrderValidity(order);

			if (currentOrderValidity == OrderValidity.Valid) {
				this._appView.outputTitleWithOrder(order);
				this._board = this._magicSquare.solve(order);
				this.showBoard(this._board);
			} else
				this.showOrderValidityErrorMessage(currentOrderValidity);

			order = this._appView.inputOrder();

		}
		this.showMessage(MessageID.Notice_EndMagicSquare);
	}

	private void showOrderValidityErrorMessage(OrderValidity anOrderValidity) {
		switch (anOrderValidity) {
		case TooSmall:
			this.showMessage(MessageID.Error_OrderIsTooSmall);
			break;
		case TooLarge:
			this.showMessage(MessageID.Error_OrderIsTooLarge);
			break;
		case NotOddNumber:
			this.showMessage(MessageID.Error_OrderIsNotOddNumber);
			break;
		default:
			break;
		}
	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_BeginMagicSquare:
			this._appView.outputMessage("<<<������ Ǯ�̸� �����մϴ�>>\n");
			break;
		case Notice_EndMagicSquare:
			this._appView.outputMessage("<������ Ǯ�̸� �����մϴ�>\n");
			break;
		case Error_OrderIsTooSmall:
			this._appView.outputMessage("���� : ������ �ʹ� �۽��ϴ�. 3���� ũ�ų� ���ƾ� �մϴ�.\n");
			break;
		case Error_OrderIsTooLarge:
			this._appView.outputMessage("���� : ������ �ʹ� Ů�ϴ�. 99���� �۰ų� ���ƾ� �մϴ�.\n");
			break;
		case Error_OrderIsNotOddNumber:
			this._appView.outputMessage("���� : ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.\n");
			break;
		default:
			break;
		}

	}

	private void showBoard(Board aBoard) {
		CellLocation currentLoc = new CellLocation();
		System.out.print("      ");
		for (int i = 0; i < aBoard.order(); i++) {
			this._appView.outputColNumber(i);
		}
		System.out.println();
		for (int i = 0; i < aBoard.order(); i++) {
			this._appView.outputRowNumber(i);
			for (int j = 0; j < aBoard.order(); j++) {
				currentLoc.setRow(i);
				currentLoc.setCol(j);
				this._appView.outputCell(aBoard.cell(currentLoc));
			}
			this._appView.outputLineNext();

		}
	}

}
