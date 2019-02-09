
public class Card {

	boolean isAce;
	int suit; // カードの種類
	int rank; // カードの数字

	public Card(int s, int r) {
		suit = s;
		rank = r;
		if (r == 0) {
			isAce = true;
		}
	}

	// 種類と数字の表示
	public void showName() {
		showSuit();
		System.out.print(" の ");
		showRank();
		System.out.println();
	}

	// 引数でエースの値を11か1に変えられる
	public int getValue(boolean useAce) {
		if (isAce && useAce) {
			return 11;
		}
		return 1 + rank;
	}

	private void showSuit() {
		switch (suit) {
		case 0:
			System.out.print("スペード");
			break;
		case 1:
			System.out.print("ハート");
			break;
		case 2:
			System.out.print("ダイヤ");
			break;
		case 3:
			System.out.print("クラブ");
			break;
		default:
			break;
		}
	}

	private void showRank() {
		switch (rank) {
		case 12:
			System.out.print("キング");
			break;
		case 11:
			System.out.print("クイーン");
			break;
		case 10:
			System.out.print("ジャック");
			break;
		case 0:
			System.out.print("エース");
			break;
		default:
			System.out.print(rank + 1);
			break;
		}
	}

}
