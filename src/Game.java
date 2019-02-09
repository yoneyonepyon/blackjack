
public class Game {

	public static void main(String[] args) {
		int total = 0;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				Card c = new Card(j, i);
				c.showName();
				total++;
			}
		}
		System.out.println(total);

	}

}
