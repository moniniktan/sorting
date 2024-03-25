import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BubbleSort extends JPanel {
	private final int[] array;
	private static final int DELAY = 50;
	private final Image img;

	public BubbleSort() {
		array = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			array[i] = rand.nextInt(6);
		}
		img = new ImageIcon("resources/circle.png").getImage();
	}

	public void sort() {
		for(int k = 0; k < 6 - 1; k++) {
			for(int i = 0; i < 6 - 1 - k; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				repaint();
				try {
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < 6; i++) {
			g.drawImage(img, 50 * (i + 1), 400, array[i] * 10, array[i] * 10, null);
		}
	}
}
