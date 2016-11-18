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
 * used to generate the charts
 * 
 * @author Sophie Schumann
 * @since 15.11.2016 16:11:54
 * @version Release 5.2
 */
public class Chart {
    public LineChart<String, Number> chart;

    public XYChart.Series<String, Number> series;
    public XYChart.Series<String, Number> series2;
    
  

    public String art;

    public Chart(Pane pane, String typ) {
        art = typ;
        Axis<Number> xAxis = new NumberAxis();
        Axis<String> yAxis = new CategoryAxis();

        if (art.equals("Richtung")) {
            xAxis.setLabel("Windrichtung");
            yAxis.setLabel("Zeit");

            series = new XYChart.Series<String, Number>();
            series.setName("Windrichtung");
            series.getData().add(new Data<String, Number>("1.1.", 5));

            chart = new LineChart<String, Number>(yAxis, xAxis);
            chart.getData().add(series);
            chart.setTitleSide(Side.TOP);
            chart.setPrefSize(350, 230);
            chart.setLegendVisible(false);
            chart.setLayoutX(820);
            chart.setLayoutY(300);

        } if (art.equals("Staerke") || art.equals("Leistung")) {
            xAxis.setLabel("Windstaerke in m/s");
            yAxis.setLabel("Zeit");

            series = new XYChart.Series<String, Number>();
            series.setName("Windstaerke");
            series.getData().add(new Data<String, Number>("1.1.", 5));

            chart = new LineChart<String, Number>(yAxis, xAxis);
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

    public void setNewDataEntry(String zeit, Number wert) {
        series.getData().add(new Data<String, Number>(zeit, wert));
    }

    public void alterDataEntry(String zeit, Number wert) {
        if (chart.getData().contains(zeit)) {
            int index = chart.getData().indexOf(zeit);
            series.getData().set(index, new Data<String, Number>(zeit, wert));
        } else {
            series.getData().add(new Data<String, Number>(zeit, wert));
        }
    }

    public void setNewSeries(XYChart.Series<String, Number> serie) {
        chart.getData().add(serie);
    }

    public void enableEventHandler() {
        ClickHandler handler = new ClickHandler(series, art);
        chart.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

}
