
public class Game {

	public static void main(String[] args) {
		Deck d = new Deck("プレイヤー");
		d.shuffle(3); // 3回ほど混ぜる
		d.showName();
	}

}
