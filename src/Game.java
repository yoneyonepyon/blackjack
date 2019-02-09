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
			System.out.println(d.canLoop);
			d.showHand();
			System.out.println("\nカードを引きますか？ (1: はい, 2: いいえ) :");
			String key = sc.next();
			switch (key) {
			case "1":
				System.out.println("カードを引きます");
				d.draw();
				break;
			case "2":
				d.canLoop = false;
				break;
			default:
				break;
			}
		} while (d.canLoop);

		sc.close();
	}

}
