package Charts;

import Handler.ClickHandler;
import javafx.geometry.Side;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * 
 * 
 * @author Sophie Schumann
 * @since 15.11.2016 16:11:54
 * @version Release 5.2
 */
public class Chart {
    public LineChart<Number, String> chart;

    public XYChart.Series<Number, String> series;

    public String art;

    public Chart(Pane pane, String typ) {
        art = typ;
        Axis<Number> xAxis = new NumberAxis();
        Axis<String> yAxis = new CategoryAxis();

        if (art.equals("Richtung")) {
            xAxis.setLabel("Windrichtung");
            yAxis.setLabel("Zeit");

            series = new XYChart.Series<Number, String>();
            series.setName("Windrichtung");
            series.getData().add(new Data<Number, String>(5, "1.1."));

            chart = new LineChart<Number, String>(xAxis, yAxis);
            chart.getData().add(series);
            chart.setTitleSide(Side.TOP);
            chart.setPrefSize(350, 230);
            chart.setLegendVisible(false);
            chart.setLayoutX(820);
            chart.setLayoutY(300);

        } else if (art.equals("Staerke") || art.equals("Leistung")) {
            xAxis.setLabel("Windstaerke in m/s");
            yAxis.setLabel("Zeit");

            series = new XYChart.Series<Number, String>();
            series.setName("Windstaerke");
            series.getData().add(new Data<Number, String>(5, "1.1."));

            chart = new LineChart<Number, String>(xAxis, yAxis);
            chart.getData().add(series);
            chart.setTitleSide(Side.TOP);
            chart.setPrefSize(350, 230);
            chart.setLegendVisible(false);
            chart.setLayoutX(820);
            chart.setLayoutY(300);

        }

        pane.getChildren().add(chart);
    }

    public void setLayout(double x, double y) {
        chart.setLayoutX(x);
        chart.setLayoutY(y);
    }

    public void setNewDataEntry(Number wert, String zeit) {
        series.getData().add(new Data<Number, String>(wert, zeit));
    }

    public void enableEventHandler() {
        ClickHandler handler = new ClickHandler(art);
        chart.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

}
