import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HeapSort extends JPanel {
	private final int[] array;
	private static final int DELAY = 50;
	private final Image img;

	public HeapSort() {
		array = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			array[i] = rand.nextInt(5) + 1;
		}
		img = new ImageIcon("resources/circle.png").getImage();
	}

	public void sort() {
		for (int i = 6 / 2 - 1; i >= 0; i--) {
			sink(6, i);
		}

		for (int i = 6 - 1; i > 0; i--) {
			swap(0, i);
			sink(i, 0);
			repaint();
			try {
				Thread.sleep(DELAY);
				super.repaint();
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void sink(int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && array[left] > array[largest]) {
			largest = left;
		}

		if (right < n && array[right] > array[largest]) {
			largest = right;
		}

		if (largest != i) {
			swap(i, largest);
			sink(n, largest);
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
