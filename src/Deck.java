import java.util.Random;

public class Deck {

	boolean isDrawable = true; // 手札を引き続けることができるか
	int playerSum = 0; // プレイヤーの役の合計
	int dealerSum = 0; // ディーラーの役の合計
	Card[] cards = new Card[52]; // 山札のカード
	Card[] hand = new Card[0]; // プレイヤーの手札
	Card[] dealerHand = new Card[0]; // ディーラーの手札
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
	public Card drawPlayer() {
		Card[] c = drawPlayer(1);
		return c[0];
	}

	// n枚分のカードを配列で返す
	public Card[] drawPlayer(int n) {
		return draw(n, true);
	}

	public Card drawDealer() {
		Card[] c = drawDealer(1);
		return c[0];
	}

	public Card[] drawDealer(int n) {
		return draw(n, false);
	}

	private Card[] draw(int n, boolean isPlayer) {
		// カードをこれ以上引けない場合はnullを返す
		if (cards.length - n < 0) {
			return null;
		}

		Card[] deck = isPlayer ? hand : dealerHand;

		// 引いた手札、引いた分を加えた手札と残りのカード用の配列を用意
		Card[] drawCards = new Card[n];
		Card[] handCards = new Card[deck.length + n];
		Card[] deckCards = new Card[cards.length - n];

		// 現在の手札を新しい配列にコピー
		for (int i = 0; i < deck.length; i++) {
			handCards[i] = deck[i];
		}

		// 引いたカードを山札に加える
		for (int i = 0; i < cards.length; i++) {
			Card c = cards[i];
			if (i < n) {
				drawCards[i] = c;
				handCards[i + deck.length] = c;
			} else {
				deckCards[i - n] = c;
			}
		}

		if (isPlayer) {
			hand = handCards;
		} else {
			dealerHand = handCards;
		}

		cards = deckCards;
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

	// プレイヤーの手札のshowName()を実行する
	public void showPlayerHand() {
		playerSum = showHand(name, hand);
		System.out.println("手札の合計値: " + playerSum);
	}

	// ディーラーの手札のshowName()を実行する
	public void showDealerHand() {
		dealerSum = showHand("ディーラー", dealerHand);
		System.out.println("手札の合計値: " + dealerSum);
	}

	// 手札のshowName()を実行する
	private int showHand(String userName, Card[] deck) {
		System.out.println(userName + "の手札:");
		for (Card c : hand) {
			if (c != null) {
				c.showName();
			}
		}
		return calcHand(deck);
	}

	// 手札の合計値を計算する
	private int calcHand(Card[] deck) {
		int sum = 0;

		// エースを11として計算する
		for (Card c : deck) {
			sum += c.getValue(true);
		}

		if (sum <= 21) {
			return sum;
		}

		// エースを1として再計算
		sum = 0;
		for (Card c : deck) {
			sum += c.getValue(false);
		}
		return sum;
	}

	public void greet() {
		System.out.println("\n" + name + "さん、ようこそ。\n");
	}

}
