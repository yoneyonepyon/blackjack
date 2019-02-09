import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("名前を入力してください:");
		String name = sc.next();

		Deck d = new Deck(name);
		d.shuffle(3);
		d.greet();

		d.draw(2);

		// プレイヤーのターン
		do {
			d.showHand();

			// 開幕にいきなり勝つ、あるいは負けることがあるので最初に計算する
			if (d.playerSum >= 21) {
				break;
			}

			System.out.println("\nカードを引きますか？ (1: はい, 2: いいえ) :");
			String key = sc.next();
			switch (key) {
			case "1":
				System.out.println("カードを引きました:");
				Card c = d.draw();
				c.showName();
				System.out.println();
				break;
			case "2":
				d.isDrawable = false;
				break;
			default:
				break;
			}
		} while (d.isDrawable);

		sc.close();
	}

}
