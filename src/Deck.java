import java.util.Random;

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
				cards[ii++] = c;
			}
		}
	}

	// 山札をシャッフルする(おそらくすごい単純な方法)
	public void shuffle() {
		Random rnd = new Random();
		for (int i = 0; i < cards.length; i++) {
			int j = rnd.nextInt(cards.length);
			Card c1 = cards[i];
			Card c2 = cards[j];
			cards[j] = c1;
			cards[i] = c2;
		}
	}

	// n回シャッフルする
	public void shuffle(int n) {
		for (int i = 0; i < n; i++) {
			shuffle();
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
