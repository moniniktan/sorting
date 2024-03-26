import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class QuickSort extends JPanel {
	private final int[] array;
	private static final int DELAY = 50;
	private final Image img;

	public QuickSort() {
		array = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			array[i] = rand.nextInt(5) + 1;
		}
		img = new ImageIcon("resources/circle.png").getImage();
	}

	public void sort() {
		quickSort(0, 6 - 1);
	}

	private void quickSort(int low, int high) {
		if (low < high) {
			int split_index = partition(low, high);
			quickSort(low, split_index - 1);
			quickSort(split_index + 1, high);
		}
	}

	private int partition(int low, int high) {
		int pivot = array[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				i++;
				swap(i, j);

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
		swap(i + 1, high);

		return i + 1;
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