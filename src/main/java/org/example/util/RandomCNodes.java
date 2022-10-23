package org.example.util;

import org.example.cnode.CNode;
import javafx.geometry.Insets;
import org.example.sortingalgorithm.AbstractSort;
import org.example.view.AnimationController;

import java.util.Random;
public class RandomCNodes {

	
	
    public RandomCNodes() {

    }

    public static CNode[] randomCNodes(int n) {
        CNode[] arr = new CNode[n];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new CNode(1 + r.nextInt(arr.length));
            
            arr[i].setPadding(new Insets(5, 5, 5, 5+ i * (AnimationController.WINDOW_WIDTH / arr.length)));// top right bot left
//            arr[i].setX(5+ i * (AnimationController.WINDOW_WIDTH / arr.length));
//            arr[i].setY(100);
            arr[i].getRectangle().setFill(AbstractSort.START_COLOR);
            setCNodeDim(arr[i], arr.length);
        }
        return arr;
    }

    private static void setCNodeDim(CNode cnode, int n) {
    	
        cnode.getRectangle().setWidth(AnimationController.WINDOW_WIDTH / n - AnimationController.XGAP);
        cnode.getRectangle().setHeight(((AnimationController.WINDOW_HEIGHT - AnimationController.BUTTONROW_BOUNDARY) / n) * cnode.getValue());

    }
}
