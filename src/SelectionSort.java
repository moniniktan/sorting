import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SelectionSort extends JPanel {
	private final int[] array;
	private static final int DELAY = 50;
	private final Image img;

	public SelectionSort() {
		array = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			array[i] = rand.nextInt(5) + 1;
		}
		img = new ImageIcon("resources/circle.png").getImage();
	}

	public void sort() {
		for (int i = 0; i < 6 - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < 6; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
				repaint();
				try {
					Thread.sleep(DELAY);
					super.repaint();
					repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			swap(i, minIndex);
		}
	}

	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < 6; i++) {
			g.drawImage(img, 200 * (i + 1), 300, array[i] * 40, array[i] * 40, null);
		}
	}
}