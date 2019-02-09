
public class Game {

	public static void main(String[] args) {
		Deck d = new Deck("プレイヤー");
		// d.shuffle(3); // 3回ほど混ぜる
		d.draw(2); // 二枚ドローする
		d.showHand(); // 手札を見せる
		d.draw(); // 二枚ドローする
		d.showHand(); // 手札を見せる
		d.showName();
	}

}
