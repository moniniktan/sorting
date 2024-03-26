import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class InsertionSort extends JPanel {
	private final int[] array;
	private static final int DELAY = 50;
	private final Image img;

	public InsertionSort() {
		array = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			array[i] = rand.nextInt(5) + 1;
		}
		img = new ImageIcon("resources/circle.png").getImage();
	}

	public void sort() {
		for (int i = 1; i < 6; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
				repaint();
				try {
					Thread.sleep(DELAY);
					super.repaint();
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			array[j + 1] = key;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < 6; i++) {
			g.drawImage(img, 200 * (i + 1), 300, array[i] * 40, array[i] * 40, null);
		}
	}
}

