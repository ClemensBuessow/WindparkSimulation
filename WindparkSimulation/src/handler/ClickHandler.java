package handler;

import gui.GuiDataInput;
import javafx.event.EventHandler;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;

public class ClickHandler implements EventHandler<MouseEvent> {
    XYChart.Series<String, Number> serie = new XYChart.Series<String, Number>();

    String art;

    public ClickHandler(XYChart.Series<String, Number> series, String art) {
        serie = series;
        this.art = art;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("wurde gehandelt");
        GuiDataInput daten = new GuiDataInput();
        daten.GuiDatenEingebens(serie, art);
    }
}
