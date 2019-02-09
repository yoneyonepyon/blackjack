import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("名前を入力してください:");
		String name = sc.next();

		Deck d = new Deck(name);
		d.shuffle(3);
		d.greet();

		d.drawPlayer(2);
		d.drawDealer(2);

		// プレイヤーのターン
		do {
			d.showPlayerHand();

			// 開幕にいきなり勝つ、あるいは負けることがあるので最初に計算する
			if (d.playerSum >= 21) {
				break;
			}

			System.out.println("\nカードを引きますか？ (1: はい, 2: いいえ) :");
			String key = sc.next();
			switch (key) {
			case "1":
				System.out.println("カードを引きました:");
				Card c = d.drawPlayer();
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

		System.out.println();

		// プレイヤー側の勝利判定
		if (d.playerSum == 21) {
			System.out.println("ブラックジャック");
			System.out.println(d.name + "の勝ちです");
		} else if (d.playerSum > 21) {
			System.out.println(d.name + "の手札の合計値が21を超えました");
			System.out.println(d.name + "の負けです");
		} else {
			// ディーラーのターン
			while (true) {
				d.showDealerHand();

				// ディーラーは17以上になるまでカードを引き続ける
				if (d.dealerSum >= d.playerSum || d.dealerSum >= 17) {
					break;
				}

				System.out.println("カードを引きました:");
				Card c = d.drawDealer();
				c.showName();
				System.out.println();
			}

			System.out.println();
			System.out.println(d.name + "の合計値: " + d.playerSum);
			System.out.println("ディーラーの合計値: " + d.dealerSum);
			System.out.println();

			if (d.dealerSum == 21) {
				System.out.println("ブラックジャック");
				System.out.println("ディーラーの勝ちです");
			} else if (d.dealerSum == d.playerSum) {
				System.out.println("引き分けです");
			} else if (d.dealerSum > 21) {
				System.out.println("ディーラーの手札の合計値が21を超えました");
				System.out.println(d.name + "の勝ちです");
			} else if (d.playerSum > d.dealerSum) {
				System.out.println(d.name + "の勝ちです");
			} else {
				System.out.println("ディーラーの勝ちです");
			}
		}

		sc.close();
	}

}
