public class AppController {
	private AppView _appView;
	private Calculate _calculate;

	public AppController() {
		this._appView = new AppView();
		this._calculate = new Calculate();
	}

	public void evalExpression() {
		double finalValue;
		this.showMessage(MessageID.Notice_InfixToPostfix);
		if (this._calculate.infixToPostfix()) {
			this._appView.outputPostfix(this._calculate.postfix());
			finalValue = this._calculate.evalPostfix();
			this._appView.outputResult(finalValue);
		} else
			this.showMessage(MessageID.Error_Input);
	}

	public void run() {
		this.showMessage(MessageID.Notice_StartProgram);
		this.showMessage(MessageID.Notice_StartMenu);
		String input = this._appView.inputExpression();
		while (input.charAt(0) != '!') {
			this._calculate.setInfix(input);
			this.evalExpression();
			input = this._appView.inputExpression();
		}
		this.showMessage(MessageID.Notice_EndMenu);
		this.showMessage(MessageID.Notice_EndProgram);

	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println(":: ���α׷��� �����մϴ�. ::");
			break;
		case Notice_EndProgram:
			System.out.println(":: ���α׷��� �����մϴ�. ::");
			break;
		case Notice_StartMenu:
			System.out.println("[���� �Է��� �����մϴ�.]");
			break;
		case Notice_EndMenu:
			System.out.println("[���� �Է��� �����մϴ�.]");
			break;
		case Notice_InfixToPostfix:
			System.out.println("[Infix�� Postfix��]");
			break;
		default:
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}
}
