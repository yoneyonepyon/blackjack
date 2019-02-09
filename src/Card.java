
public class Card {

	int suit; // カードの種類
	int rank; // カードの数字

	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// 種類と数字の表示
	public void showName() {
		showSuit();
		System.out.print(" の ");
		showRank();
		System.out.println();
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
			System.out.print(rank);
			break;
		}
	}

}
