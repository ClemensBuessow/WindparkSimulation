package charts;

import javafx.application.Platform;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ComboBox;
import mapElements.Cloud;
import mapElements.WindWheel;

public class addDataCharts extends Thread {
	long interval;
	boolean outOfIndex = true;
	Series<String, Number> series;
	Series<String, Number> series2;
	int counter;
	boolean boeen;
	WindWheel windWheelOne;
	WindWheel windWheelTwo;
	WindWheel windWheelThree;
	WindWheel windWheelFour;
	WindWheel windWheelFive;
	WindWheel windWheelSix;

	Cloud cloud;
	Cloud cloudTwo;
	Cloud cloudThree;
	ComboBox<String> windDirection;

	int windWheelNumber = 6;

	public addDataCharts(long interval, Series<String, Number> series, Series<String, Number> series2, int counter,
			boolean boeen, WindWheel w1, WindWheel w2, WindWheel w3, WindWheel w4, WindWheel w5, WindWheel w6,
			ComboBox<String> c1, Cloud cloudOne, Cloud cloud2, Cloud cloud3) {
		setDaemon(true);
		setName("thread-1");

		this.interval = interval;
		this.counter = counter;
		this.series = series;
		this.series2 = series2;
		this.boeen = boeen;
		this.windWheelOne = w1;
		this.windWheelTwo = w2;
		this.windWheelThree = w3;
		this.windWheelFour = w4;
		this.windWheelFive = w5;
		this.windWheelSix = w6;
		this.windDirection = c1;
		this.cloud = cloudOne;
		this.cloudTwo = cloud2;
		this.cloudThree = cloud3;
		setDaemon(true);

	}

	public void run() {

		// hier das andere
		while (counter <= series.getData().size()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						Data<String, Number> data = series.getData().get(counter);
						System.out.println(data);
						Double test = Double.parseDouble(data.getXValue());
						Double test2 = data.getYValue().doubleValue();
						String wind = data.getExtraValue().toString();
						if (boeen == true) {
							if (test2 >= 10 && test2 <= 15) {

								Data<String, Number> a = new Data<String, Number>(test.toString(),
										((test2 / 4) * windWheelNumber) + Math.random(), wind);

								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								try {
									series2.getData().add(a);
								} catch (IllegalStateException e) {
									System.out.println("Das Ja blöd jetzt");
								}
								System.out.println(a);

							} else if (test2 < 5) {

								Data<String, Number> a = new Data<String, Number>(test.toString(),
										((test2 * 0) * windWheelNumber) + Math.random(), wind);
								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);

								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									// TODO: handle exception
									System.out.println("Kann ja mal passieren");
								}

							} else if (test2 >= 5 && test2 < 10) {
								Data<String, Number> a = new Data<String, Number>(test.toString(),
										((test2 / 4.5) * windWheelNumber) + Math.random(), wind);
								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);
								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									System.out.println("Nicht so cool");
								}

							} else if (test2 > 15 && test2 < 25) {
								Data<String, Number> a = new Data<String, Number>(test.toString(),
										3.6 * windWheelNumber, wind);
								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);
								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									System.out.println("Nicht so cool");
								}

							} else if (test2 > 25) {

								Data<String, Number> a = new Data<String, Number>(test.toString(), test2 * 0, wind);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);

								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									System.out.println("Nicht so cool");
								}
							}
						}
						if (boeen == false) {
							if (test2 >= 10 && test2 <= 15) {

								Data<String, Number> a = new Data<String, Number>(test.toString(),
										(test2 / 4) * windWheelNumber, wind);

								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);

								try {
									series2.getData().add(a);
								} catch (IllegalStateException e) {
									System.out.println("Das Ja blöd jetzt");
								}
								System.out.println(a);

							} else if (test2 < 5) {
								Data<String, Number> a = new Data<String, Number>(test.toString(), test2 * 0, wind);
								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);

								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									// TODO: handle exception
									System.out.println("Kann ja mal passieren");
								}

							} else if (test2 >= 5 && test2 < 10) {

								Data<String, Number> a = new Data<String, Number>(test.toString(),
										(test2 / 4.5) * windWheelNumber, wind);
								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);

								a.setExtraValue(wind);
								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									System.out.println("Nicht so cool");
								}

							} else if (test2 > 15 && test < 25) {
								Data<String, Number> a = new Data<String, Number>(test.toString(),
										3.6 * windWheelNumber, wind);
								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);

								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									System.out.println("Nicht so cool");
								}

							} else if (test2 > 25) {
								Data<String, Number> a = new Data<String, Number>(test.toString(), test2 * 0, wind);
								System.out.println(a);
								if (a.getExtraValue().equals("Nord - Nord/Ost")) {
									changeDirectionToNorth();
								} else if (a.getExtraValue().equals("Ost - Süd/Ost")) {
									changeDirectionToEast();
									System.out.println(a);
								} else if (a.getExtraValue().equals("Süd - Süd/West")) {
									changeDirectionToSouth();
									System.out.println(a);
								} else if (a.getExtraValue().equals("West - Nord/West")) {
									changeDirectionToWest();
									System.out.println(a);
								}

								System.out.println(series2);

								System.out.println(a);
								try {
									series2.getData().add(a);
								} catch (Exception e) {
									System.out.println("Nicht so cool");
								}
							}
						}
						if (counter > series.getData().size()) {
							return;

						}
						counter++;
						System.out.println("Ich bin ein Thread");

					} catch (IndexOutOfBoundsException e) {

					}

				}

			});

			// Thread schlafen
			try {

				sleep(interval);

			} catch (InterruptedException e) {
				// abfangen
				System.out.println("Diese kack Threads!");
			}

		}
	}

	private void changeDirectionToWest() {
		cloud.setXY(150.0, 160.0);
		cloud.translateToWindDirection(-80.0, 0.0, 0.0, 4.0);

		cloudTwo.setXY(350.0, 160.0);
		cloudTwo.translateToWindDirection(-80.0, 0.0, 0.0, 4.0);

		cloudThree.setXY(550.0, 160.0);
		cloudThree.translateToWindDirection(-80.0, 0.0, 0.0, 4.0);

		windWheelOne.rotateToWindDirection(270.0, 7);
		windWheelTwo.rotateToWindDirection(270.0, 7);
		windWheelThree.rotateToWindDirection(270.0, 7);
		windWheelFour.rotateToWindDirection(270.0, 7);
		windWheelFive.rotateToWindDirection(270.0, 7);
		windWheelSix.rotateToWindDirection(270.0, 7);
	}

	private void changeDirectionToEast() {
		cloud.setXY(150.0, 160.0);
		cloud.translateToWindDirection(80.0, 0.0, 0.0, 4.0);

		cloudTwo.setXY(350.0, 160.0);
		cloudTwo.translateToWindDirection(80.0, 0.0, 0.0, 4.0);

		cloudThree.setXY(550.0, 160.0);
		cloudThree.translateToWindDirection(80.0, 0.0, 0.0, 4.0);

		windWheelOne.rotateToWindDirection(90.0, 4);
		windWheelTwo.rotateToWindDirection(90.0, 4);
		windWheelThree.rotateToWindDirection(90.0, 4);
		windWheelFour.rotateToWindDirection(90.0, 4);
		windWheelFive.rotateToWindDirection(90.0, 4);
		windWheelSix.rotateToWindDirection(90.0, 4);
	}

	private void changeDirectionToSouth() {
		cloud.setXY(150.0, 160.0);
		cloud.translateToWindDirection(80.0, -20.0, 0.0, 4.0);

		cloudTwo.setXY(350.0, 160.0);
		cloudTwo.translateToWindDirection(80.0, -20.0, 0.0, 4.0);

		cloudThree.setXY(550.0, 160.0);
		cloudThree.translateToWindDirection(80.0, -20.0, 0.0, 4.0);

		windWheelOne.rotateToWindDirection(360.0, 4);
		windWheelTwo.rotateToWindDirection(360.0, 4);
		windWheelThree.rotateToWindDirection(360.0, 4);
		windWheelFour.rotateToWindDirection(360.0, 4);
		windWheelFive.rotateToWindDirection(360.0, 4);
		windWheelSix.rotateToWindDirection(360.0, 4);

	}

	private void changeDirectionToNorth() {

		cloud.setXY(150.0, 160.0);
		cloud.translateToWindDirection(-80.0, 20.0, 45.0, 4.0);

		cloudTwo.setXY(350.0, 160.0);
		cloudTwo.translateToWindDirection(-80.0, 20.0, 45.0, 4.0);

		cloudThree.setXY(550.0, 160.0);
		cloudThree.translateToWindDirection(-80.0, 20.0, 45.0, 4.0);

		windWheelOne.rotateToWindDirection(180.0, 6);
		windWheelTwo.rotateToWindDirection(180.0, 6);
		windWheelThree.rotateToWindDirection(180.0, 6);
		windWheelFour.rotateToWindDirection(180.0, 6);
		windWheelFive.rotateToWindDirection(180.0, 6);
		windWheelSix.rotateToWindDirection(180.0, 6);

	}

}
