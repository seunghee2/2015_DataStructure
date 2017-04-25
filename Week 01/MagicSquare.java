public class MagicSquare {
	private static final int DEFAULT_MAX_ORDER = 99;

	private int _maxOrder;
	private int _order;
	private Board _board;

	public MagicSquare() {
		this._maxOrder = MagicSquare.DEFAULT_MAX_ORDER;
		this._order = 3;
		this._board = null;
	}

	public MagicSquare(int givenMaxOrder) {
		this._maxOrder = givenMaxOrder;
		this._order = 3;
		this._board = null;
	}

	public OrderValidity checkOrderValidity(int order) {
		if (order < 3)
			return OrderValidity.TooSmall;
		else if (order > 99)
			return OrderValidity.TooLarge;
		else if (order % 2 == 0)
			return OrderValidity.NotOddNumber;
		else
			return OrderValidity.Valid;
	}

	public Board solve(int anOrder) {
		this._order = anOrder;
		if (this.checkOrderValidity(anOrder) != OrderValidity.Valid) {
			return null;
		} else {
			this._board = new Board(this._order);
			CellLocation currentLoc = new CellLocation(0, this._order / 2);
			CellLocation nextLoc = new CellLocation();

			this._board.setCell(currentLoc, 1);

			int lastNumber = this._order * this._order;
			for (int number = 2; number <= lastNumber; number++) {
				if (currentLoc.col() == _order - 1)
					nextLoc.setCol(0);
				else
					nextLoc.setCol(currentLoc.col() + 1);
				if (currentLoc.row() == 0)
					nextLoc.setRow(_order - 1);
				else
					nextLoc.setRow(currentLoc.row() - 1);
				if (!this._board.cellsEmpty(nextLoc)) {
					nextLoc.setCol(currentLoc.col());
					if (currentLoc.row() == _order - 1)
						nextLoc.setRow(0);
					else
						nextLoc.setRow(currentLoc.row() + 1);
				}
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());

				this._board.setCell(currentLoc, number);
			}
			return this._board;
		}
	}

	public int maxOrder() {
		return _order ^ 2;
	}

	public int order() {
		return _order;
	}

}
