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


public class Chart {
    public LineChart<Number, String> chartStaerke;

    public LineChart<Number, String> chartLeistung;

    public LineChart<Number, String> chartRichtung;

    public XYChart.Series<Number, String> series;

    public Chart(Pane pane, String art) {

        Axis<Number> xAxis = new NumberAxis();
        Axis<String> yAxis = new CategoryAxis();
        XYChart.Series<Number, String> series;

        if (art.equals("Richtung")) {
            xAxis.setLabel("Windrichtung");
            yAxis.setLabel("Zeit");

            series = new XYChart.Series<Number, String>();
            series.setName("Windrichtung");
            series.getData().add(new Data<Number, String>(5, "1.1."));

            chartRichtung = new LineChart<Number, String>(xAxis, yAxis);
            chartRichtung.getData().add(series);
            chartRichtung.setTitle("Windrichtung");
            chartRichtung.setTitleSide(Side.TOP);
            chartRichtung.setPrefSize(350, 230);
            chartRichtung.setLegendVisible(false);

            pane.getChildren().add(chartRichtung);
        }
        xAxis.setLabel("Windstaerke in m/s");
        yAxis.setLabel("Zeit");

        series = new XYChart.Series<Number, String>();
        series.setName("Windstaerke");
        series.getData().add(new Data<Number, String>(5, "1.1."));

        chartStaerke = new LineChart<Number, String>(xAxis, yAxis);
        chartStaerke.getData().add(series);
        chartStaerke.setTitleSide(Side.TOP);
        chartStaerke.setPrefSize(350, 230);
        chartStaerke.setLegendVisible(false);
        chartStaerke.setLayoutX(820);
        chartStaerke.setLayoutY(300);
        chartStaerke.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClickHandler(art));

        pane.getChildren().add(chartStaerke);

    }

    public void setLayout(Double x, Double y) {
        chartStaerke.setLayoutX(x);
        chartStaerke.setLayoutY(y);

    }

    public void setNewDataEntry(Number wert, String zeit) {
        series.getData().add(new Data<Number, String>(wert, zeit));
    }
}
