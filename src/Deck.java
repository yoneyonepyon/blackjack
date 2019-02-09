import java.util.Random;

public class Deck {

	Card[] cards = new Card[52]; // 山札のカード
	Card[] hand = new Card[0]; // 手札のカード
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

	// 1枚カードをひく
	public Card draw() {
		Card[] c = draw(1);
		return c[0];
	}

	// n枚分のカードを配列で返す
	public Card[] draw(int n) {
		// カードをこれ以上引けない場合はnullを返す
		if (cards.length - n < 0) {
			return null;
		}

		// 引いた手札、引いた分を加えた手札と残りのカード用の配列を用意
		Card[] drawCards = new Card[n];
		Card[] handCards = new Card[hand.length + n];
		Card[] deckCards = new Card[cards.length - n];

		// 現在の手札を新しい配列にコピー
		for (int i = 0; i < hand.length; i++) {
			handCards[i] = hand[i];
		}

		// 引いたカードを山札に加える
		for (int i = 0; i < cards.length; i++) {
			Card c = cards[i];
			if (i < n) {
				drawCards[i] = c;
				handCards[i + hand.length] = c;
			} else {
				deckCards[i - n] = c;
			}
		}

		cards = deckCards;
		hand = handCards;
		return drawCards;
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
		System.out.println(name + "の山札:");
		for (Card c : cards) {
			c.showName();
		}
		System.out.println("山札の枚数: " + cards.length);
	}

	// 手札のshowName()を実行する
	public void showHand() {
		System.out.println(name + "の手札:");
		for (Card c : hand) {
			if (c != null) {
				c.showName();
			}
		}
		System.out.println("手札の枚数: " + hand.length);
	}

}
