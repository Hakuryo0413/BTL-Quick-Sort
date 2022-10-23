package org.example.sortingalgorithm;

import org.example.cnode.CNode;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.example.view.AnimationController;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSort {
    static int DX;

    static {
        DX = AnimationController.WINDOW_WIDTH / AnimationController.NO_OF_CNODES;
    }

    public static final Color START_COLOR = Color.LIGHTSKYBLUE;
    final Color SORTED_COLOR = Color.ORANGE;


    ParallelTransition colorCNode(CNode[] arr, Color color, boolean isDelay, int... a) {
        ParallelTransition pt = new ParallelTransition();
        for (int i = 0; i < a.length; i++) {
            FillTransition ft = new FillTransition();
            ft.setShape(arr[a[i]].getRectangle());
            ft.setToValue(color);
            ft.setDuration(Duration.millis(isDelay ? 200 : 1));
            pt.getChildren().add(ft);
        }
        return pt;
    }

    ParallelTransition colorCNode(List<CNode> list, Color color) {
        ParallelTransition pt = new ParallelTransition();
        for (CNode c : list) {
            FillTransition ft = new FillTransition();
            ft.setShape(c.getRectangle());
            ft.setToValue(color);
            ft.setDuration(Duration.millis(400));
            pt.getChildren().add(ft);
        }
        return pt;
    }

    ParallelTransition swap(CNode[] arr, int i, int j) {
        ParallelTransition pt = new ParallelTransition();
        int dxFactor = j - i;
        pt.getChildren().addAll(arr[i].moveX(DX * dxFactor), arr[j].moveX(-DX * dxFactor));
        CNode tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        
        
        return pt;

    }

    public abstract ArrayList<Transition> startSort(CNode[] arr);
}
