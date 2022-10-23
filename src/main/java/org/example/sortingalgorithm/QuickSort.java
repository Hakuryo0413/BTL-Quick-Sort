package org.example.sortingalgorithm;

import org.example.cnode.CNode;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort extends AbstractSort {
	private static final Color PIVOT_COLOR = Color.YELLOW;
	private static final Color BIGGER_COLOR = Color.PURPLE;
	private static final Color SMALLER_COLOR = Color.GREEN;
	private static final Color SELECT_COLOR = Color.RED;
	private ArrayList<Transition> transitions;

	public QuickSort() {
		this.transitions = new ArrayList<>();
	}

	private void quickSort(CNode[] arr, int low, int high) {
		if (low < high) {
			int q = partition(arr, low, high);
			quickSort(arr, low, q - 1);
			quickSort(arr, q + 1, high);
		} else if (low == high) {
			// xử lý trường hợp lỗi 1 phần tử ko đổi màu
			arr[high].setRightColor(true);
			transitions.add(colorCNode(arr, SORTED_COLOR, true, high));

		}
	}

	/*
	 * private void checkSort(CNode[] arr, int i,boolean c){ if(c == true){
	 * transitions.add(colorCNode(arr,SORTED_COLOR,i)); } else
	 * transitions.add(colorCNode(arr,START_COLOR,i)); }
	 */
	private int partition(CNode[] arr, int low, int high) {
		// Boolean[] array = new Boolean[arr.length-1];
		// Arrays.fill(array, Boolean.FALSE);
		CNode pivot = arr[high];
		// pivot (Element to be placed at right position)
		transitions.add(colorCNode(arr, PIVOT_COLOR, true, high));

		int i = low - 1;

		for (int j = low; j < high; j++) {
			transitions.add(colorCNode(arr, SELECT_COLOR, true, j));

			if (arr[j].getValue() <= pivot.getValue()) {
				transitions.add(colorCNode(arr, SMALLER_COLOR, true, j));
				i++;
				transitions.add(swap(arr, i, j));
			} else {
				transitions.add(colorCNode(arr, BIGGER_COLOR, true, j));
			}
		}

		transitions.add(swap(arr, i + 1, high));

		/*
		 * int k=i+1; int l = arr.length-1; array[k] = true; while(l>0){
		 * checkSort(arr,l,array[l]); l--;}
		 */

		int sorted = i + 1;
		arr[sorted].setRightColor(true);
		transitions.add(colorCNode(arr, SORTED_COLOR, true, sorted));

		for (int j = 0; j < arr.length; j++) {
			if (j != sorted) {
				if (!arr[j].isRightColor()) {
					transitions.add(colorCNode(arr, START_COLOR, false, j));
				}
			}
		}

		// transitions.add(colorCNode(arr,PIVOT_COLOR,i+1));*/
		return i + 1;
	}

	@Override
	public ArrayList<Transition> startSort(CNode[] arr) {
		quickSort(arr, 0, arr.length - 1);
		transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

		return transitions;
	}

}

