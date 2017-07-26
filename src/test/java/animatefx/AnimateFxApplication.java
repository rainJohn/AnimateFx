package animatefx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AnimateFxApplication extends Application {

    private StackPane animationNodeContainer = new StackPane();

    private Node animationNode = new Button("AnimateFx");

    private final EventHandler<ActionEvent> onFinished = actionEvent -> addAnimationNode();

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) {
        stage.setTitle("AnimateFx Application");

        addAnimationNode();

        Button btnFadeOutLeft = new Button("fadeOutLeft");
        btnFadeOutLeft.setOnAction(e -> AnimateFx.fadeOutLeft(animationNode, 500, 100, onFinished));

        Button btnFadeOutRight = new Button("fadeOutRight");
        btnFadeOutRight.setOnAction(e -> AnimateFx.fadeOutRight(animationNode, 500, 100, onFinished));

        Button btnFlash = new Button("flash");
        btnFlash.setOnAction(e -> AnimateFx.flash(animationNode, 500, onFinished));

        Button btnPulse = new Button("pulse");
        btnPulse.setOnAction(e -> AnimateFx.pulse(animationNode, 500, 1.2, onFinished));

        Button btnRubberBand = new Button("rubberBand");
        btnRubberBand.setOnAction(e -> AnimateFx.rubberBand(animationNode, 500, onFinished));

        Button btnZoomIn = new Button("zoomIn");
        btnZoomIn.setOnAction(e -> AnimateFx.zoomIn(animationNode, 500, onFinished));

        VBox controls = new VBox();
        controls.getChildren().addAll(btnFadeOutLeft, btnFadeOutRight, btnFlash, btnPulse, btnRubberBand);
        controls.getChildren().addAll(btnZoomIn);

        BorderPane bp = new BorderPane();
        bp.setRight(controls);
        bp.setCenter(animationNodeContainer);

        stage.setScene(new Scene(bp, 500, 500));
        stage.show();
    }

    private void addAnimationNode() {
        animationNodeContainer.getChildren().clear();
        animationNode = new Button("AnimateFx");
        animationNodeContainer.getChildren().add(animationNode);
    }
}