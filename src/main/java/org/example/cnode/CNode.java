package org.example.cnode;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CNode extends VBox {
    private int value;
    private Rectangle rectangle = new Rectangle();
    private Text text = new Text();
    private boolean isRightColor = false;

    public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public boolean isRightColor() {
		return isRightColor;
	}

	public void setRightColor(boolean isRightColor) {
		this.isRightColor = isRightColor;
	}

	public CNode(int value) { // setValue;
        this.value = value;
        text.setText(String.valueOf(value));
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(text, rectangle);
    }

    public int getValue() {
        return this.value;
    }

    public TranslateTransition moveX(int x) {
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(this);
        tt.setDuration(Duration.millis(200));
        tt.setByX(x);
        return tt;
    }




}
