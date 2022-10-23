package org.example.view;

import org.example.cnode.CNode;
import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import org.example.sortingalgorithm.AbstractSort;
import org.example.sortingalgorithm.QuickSort;
import org.example.util.RandomCNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimationController extends BorderPane {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int XGAP = 5;
    public static final int BUTTONROW_BOUNDARY = 200;

    public static int NO_OF_CNODES = 15;

    public static AbstractSort abstractSort;

    private final Pane display;
    
    private final HBox buttonRow;
    private final Button sortButton;
    private final Button randomButton;
    private final ChoiceBox<AbstractSort> choiceBox;
    private CNode[] cnodes;
    private List<CNode> listNode;
    
    public AnimationController() {
        this.display = new Pane();
        
        this.buttonRow = new HBox();

        this.setCenter(display);
        this.setBottom(buttonRow);

        this.sortButton = new Button("Sort");
        this.randomButton = new Button("Random");
        this.choiceBox = new ChoiceBox<>();

        this.cnodes = RandomCNodes.randomCNodes(NO_OF_CNODES);

        buttonRow.getChildren().add(sortButton);
        buttonRow.getChildren().add(randomButton);
        buttonRow.getChildren().add(choiceBox);

        buttonRow.setAlignment(Pos.CENTER);
        for (Node b : buttonRow.getChildren()) {
            HBox.setMargin(b, new Insets(10, 10, 20, 5));
        }
        List<AbstractSort> abstractSortList = new ArrayList<>();
        abstractSortList.add(new QuickSort());

        
        listNode = Arrays.asList(cnodes);
        
//        display.getChildren().addAll(listNode);

        for (int i = 0; i < listNode.size(); i++) {
			CNode node = listNode.get(i);
			node.setPadding(new Insets(5, 5, 5, 5+ i * (AnimationController.WINDOW_WIDTH / listNode.size())));// top right bot left
			display.getChildren().add(node);
		}
        
        
        sortButton.setOnAction(event -> {
        	abstractSort = choiceBox.getSelectionModel().getSelectedItem();
            if(abstractSort == null) {
            	return;
            }
            sortButton.setDisable(true);
            randomButton.setDisable(true);
            
            SequentialTransition sq = new SequentialTransition();
            sq.getChildren().addAll(abstractSort.startSort(cnodes));
            sq.setOnFinished(e -> {
                randomButton.setDisable(false);
            });
            sq.play();

        });
        randomButton.setOnAction(event -> {
            sortButton.setDisable(false);
            display.getChildren().clear();

            cnodes = RandomCNodes.randomCNodes(NO_OF_CNODES);
            
            listNode = Arrays.asList(cnodes);
            display.getChildren().addAll(listNode);
        });
        choiceBox.setItems(FXCollections.observableArrayList(abstractSortList));
        choiceBox.getSelectionModel().select(1);

        choiceBox.setConverter(new StringConverter<AbstractSort>() {
            @Override
            public String toString(AbstractSort abstractSort) {
                if (abstractSort == null) {
                    return "";
                } else {
                    return abstractSort.getClass().getSimpleName();
                }
            }

            @Override
            public AbstractSort fromString(String s) {
                return null;
            }
        });

    }


}



