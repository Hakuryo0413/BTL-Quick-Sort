package org.example.sortingalgorithm;

import javafx.animation.Transition;
import javafx.scene.paint.Color;
import org.example.cnode.CNode;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort extends AbstractSort {
    private static final Color PIVOT_COLOR = Color.YELLOW;
    private static final Color BIGGER_COLOR = Color.PURPLE;
    private static final Color SMALLER_COLOR = Color.GREEN;
    private static final Color SELECT_COLOR = Color.RED;
    private final ArrayList<Transition> transitions;

    public QuickSort() {
        this.transitions = new ArrayList<>();
    }

    // arr[] --> Mảng cần được sắp xếp,
    // low --> chỉ mục bắt đầu,
    // high --> chỉ mục kết thúc
    private void quickSort(CNode[] arr, int low, int high) {
        if (low < high) {
            // q là chỉ mục của chốt, arr[q] là vị trí của chốt
            int q = partition(arr, low, high);
            // Sắp xếp đệ quy các phần tử
            // trước phân vùng và sau phân vùng
            quickSort(arr, low, q - 1);
            quickSort(arr, q + 1, high);
        } else if (low == high) {
            // xử lý trường hợp lỗi 1 phần tử ko đổi màu
            arr[high].setRightColor(true);
            transitions.add(colorCNode(arr, SORTED_COLOR, true, high));

        }
    }

    // Hàm nhận phần tử cuối cùng làm chốt,
    // đặt các phần tử nhỏ hơn chốt ở trước
    // và lớn hơn ở sau nó
    private int partition(CNode[] arr, int low, int high) {
        // pivot (Element to be placed at right position)
        CNode pivot = arr[high];
        // đổi màu của pivot sang PIVOT_COLOR (YELLOW)
        transitions.add(colorCNode(arr, PIVOT_COLOR, true, high));
        int i = low - 1; // vị trí của phần tử nhỏ hơn

        for (int j = low; j < high; j++) {
            // đổi màu của phần tử arr[j] sang SELECT_COLOR (RED)
            transitions.add(colorCNode(arr, SELECT_COLOR, true, j));
            // nếu phần tử hiện tại nhỏ hơn chốt
            if (arr[j].getValue() <= pivot.getValue()) {
                transitions.add(colorCNode(arr, SMALLER_COLOR, true, j)); // đổi màu sang SMALLER_COLOR (GREEN)
                i++;
                transitions.add(swap(arr, i, j));
            } else {
                transitions.add(colorCNode(arr, BIGGER_COLOR, true, j)); // đổi màu sang BIGGER_COLOR(PURPLE)
            }
        }

        transitions.add(swap(arr, i + 1, high));


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

        return i + 1;
    }

    @Override
    public ArrayList<Transition> startSort(CNode[] arr) {
        quickSort(arr, 0, arr.length - 1);
        transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));

        return transitions;
    }

}

