package Handler;
import GUI.GuiWindrad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class WindradClickHandler implements EventHandler<MouseEvent> {
    public WindradClickHandler() {

    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("wurde gehandelt");
        GuiWindrad rad = new GuiWindrad();
        rad.GuiWindradShow();

    }

}