import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class MergeSort extends JPanel {
	private final int[] array;
	private static final int DELAY = 50;
	private final Image img;

	public MergeSort() {
		array = new int[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			array[i] = rand.nextInt(5) + 1;
		}
		img = new ImageIcon("resources/circle.png").getImage();
	}

	public void sort() {
		mergeSort(array, 0, array.length - 1);
	}

	private void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
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

	private void merge(int[] arr, int low, int mid, int high) {
		int[] temp = Arrays.copyOf(arr, arr.length);
		int i = low, j = mid + 1, k = low;

		while (i <= mid && j <= high) {
			if (temp[i] <= temp[j]) {
				arr[k] = temp[i];
				i++;
			} else {
				arr[k] = temp[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			arr[k] = temp[i];
			k++;
			i++;
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
