import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting Algorithms");
		String[] algorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Heap Sort"};
		JComboBox cb = new JComboBox(algorithms);
		JButton b = new JButton("Sort");
		b.setBounds(900, 100, 150, 50);
		cb.setBounds(100, 100, 100, 100);
		cb.setSize(800, 20);
		frame.add(cb); frame.add(b);

		BubbleSort bs = new BubbleSort();
		HeapSort hs = new HeapSort();
		InsertionSort is = new InsertionSort();
		MergeSort ms = new MergeSort();
		QuickSort qs = new QuickSort();
		SelectionSort ss = new SelectionSort();

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object choice = cb.getItemAt(cb.getSelectedIndex());
				if (choice == "Bubble Sort") {
					frame.add(bs);
					bs.sort();
				} else if (choice == "Selection Sort") {
					frame.add(ss);
					ss.sort();
				} else if (choice == "Insertion Sort") {
					frame.add(is);
					is.sort();
				} else if (choice == "Merge Sort") {
					frame.add(ms);
					ms.sort();
				} else if (choice == "Quick Sort") {
					frame.add(qs);
					qs.sort();
				} else if (choice == "Heap Sort") {
					frame.add(hs);
					hs.sort();
				}
			}
		});
	}
}