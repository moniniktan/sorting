import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorting Algorithms");
		String[] algorithms = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Heap Sort"};
		JComboBox cb = new JComboBox(algorithms);
		JButton b = new JButton("Sort");
		b.setBounds(1000, 100, 100, 30);
		b.setBackground(Color.white);
		b.setBorder(new LineBorder(Color.white));
		cb.setBackground(Color.white);
		cb.setBounds(100, 100, 100, 100);
		cb.setSize(800, 20);
		frame.getContentPane().setBackground( Color.PINK);
		frame.setLayout(null);
		frame.add(cb); frame.add(b);

		BubbleSort bs = new BubbleSort();
		bs.setBounds(100, 160, 1700, 800);
//		bs.setBorder(new LineBorder(Color.RED, 1));
		frame.add(bs);
		HeapSort hs = new HeapSort();
		frame.add(hs);
		hs.setBounds(100, 160, 1700, 800);
		InsertionSort is = new InsertionSort();
		frame.add(is);
		is.setBounds(100, 160, 1700, 800);
		MergeSort ms = new MergeSort();
		frame.add(ms);
		ms.setBounds(100, 160, 1700, 800);
		QuickSort qs = new QuickSort();
		frame.add(qs);
		qs.setBounds(100, 160, 1700, 800);
		SelectionSort ss = new SelectionSort();
		frame.add(ss);
		ss.setBounds(100, 160, 1700, 800);

		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		b.addActionListener(e -> {
			Object choice = cb.getItemAt(cb.getSelectedIndex());
			if (choice == "Bubble Sort") {
				bs.sort();
			} else if (choice == "Selection Sort") {
				ss.sort();
			} else if (choice == "Insertion Sort") {
				is.sort();
			} else if (choice == "Merge Sort") {
				ms.sort();
			} else if (choice == "Quick Sort") {
				qs.sort();
			} else if (choice == "Heap Sort") {
				hs.sort();
			}
		});
	}
}