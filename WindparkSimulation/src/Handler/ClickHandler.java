package Handler;
import GUI.GuiDataInput;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class ClickHandler implements EventHandler<MouseEvent> {
    String art;

    public ClickHandler(String art) {
        this.art = art;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("wurde gehandelt");
        GuiDataInput daten = new GuiDataInput();
        daten.GuiDatenEingebens(art);
    }
}
