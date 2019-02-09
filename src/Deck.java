
public class Deck {

	Card[] cards = new Card[52]; // 山札のカード
	String name; // プレイヤーの名前

	public Deck(String n) {
		name = n;
		buildCards();
	}

	private void buildCards() {
		int ii = 0;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				Card c = new Card(j, i);
				System.out.println((4 * j) + i);
				cards[ii++] = c;
			}
		}
	}

	// カードのshowName()を実行する
	public void showName() {
		int total = 0;
		for (Card c : cards) {
			c.showName();
			total++;
		}
		System.out.println(total);
	}

}
