package charts;

import javafx.application.Platform;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class addDataCharts extends Thread {
	long interval;
	boolean outOfIndex = true;
	Series<String, Number> series;
	Series<String, Number> series2;
	int counter;
	boolean boeen;

	public addDataCharts(long interval, Series<String, Number> series, Series<String, Number> series2, int counter,
			boolean boeen) {
		setDaemon(true);
		setName("thread-1");

		this.interval = interval;
		this.counter = counter;
		this.series = series;
		this.series2 = series2;
		this.boeen = boeen;
	}

	public void run() {

		// hier das andere
		while (counter <= series.getData().size()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					Data<String, Number> data = series.getData().get(counter);

					System.out.println(data);
					Double test = Double.parseDouble(data.getXValue());
					Double test2 = data.getYValue().doubleValue();

					if (test2 >= 10 && test2 <= 15) {

						Data<String, Number> a = new Data<String, Number>(test.toString(), (test2 / 4) + Math.random());

						System.out.println(a);

						try {
							series2.getData().add(a);
						} catch (IllegalStateException e) {
							System.out.println("Das Ja blöd jetzt");
						}
						System.out.println(a);

					} else if (test2 < 5) {
						Data<String, Number> a = new Data<String, Number>(test.toString(), (test2 * 0) + Math.random());
						System.out.println(a);

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
								(test2 / 4.5) + Math.random());
						System.out.println(a);

						System.out.println(series2);
						System.out.println(a);
						try {
							series2.getData().add(a);
						} catch (Exception e) {
							System.out.println("Nicht so cool");
						}

					} else if (test2 > 15 && test2 < 25) {
						Data<String, Number> a = new Data<String, Number>(test.toString(), 3.6);
						System.out.println(a);

						System.out.println(series2);
						System.out.println(a);
						try {
							series2.getData().add(a);
						} catch (Exception e) {
							System.out.println("Nicht so cool");
						}

					} else if (test2 > 25) {
						Data<String, Number> a = new Data<String, Number>(test.toString(), test2 * 0);
						System.out.println(a);

						System.out.println(series2);

						System.out.println(a);
						try {
							series2.getData().add(a);
						} catch (Exception e) {
							System.out.println("Nicht so cool");
						}
					}
					// } else if (boeen == false) {
					// if (test >= 10 && test <= 15) {
					//
					// Data<String, Number> a = new Data<String,
					// Number>(test.toString(), test2 / 4);
					//
					// System.out.println(a);
					//
					// System.out.println(series2);
					//
					// try {
					// series2.getData().add(a);
					// } catch (IllegalStateException e) {
					// System.out.println("Das Ja blöd jetzt");
					// }
					// System.out.println(a);
					//
					// } else if (test2 < 5) {
					// Data<String, Number> a = new Data<String,
					// Number>(test.toString(), test2 * 0);
					// System.out.println(a);
					//
					// System.out.println(series2);
					//
					// System.out.println(a);
					// try {
					// series2.getData().add(a);
					// } catch (Exception e) {
					// // TODO: handle exception
					// System.out.println("Kann ja mal passieren");
					// }
					//
					// } else if (test2 > 5 && test2 < 10) {
					// Data<String, Number> a = new Data<String,
					// Number>(test.toString(), test2 / 4.5);
					// System.out.println(a);
					//
					// System.out.println(series2);
					//
					// System.out.println(a);
					// try {
					// series2.getData().add(a);
					// } catch (Exception e) {
					// System.out.println("Nicht so cool");
					// }
					//
					// } else if (test > 15 && test < 25) {
					// Data<String, Number> a = new Data<String,
					// Number>(test.toString(), 3.6);
					// System.out.println(a);
					//
					// System.out.println(series2);
					//
					// System.out.println(a);
					// try {
					// series2.getData().add(a);
					// } catch (Exception e) {
					// System.out.println("Nicht so cool");
					// }
					//
					// } else if (test > 25) {
					// Data<String, Number> a = new Data<String,
					// Number>(test.toString(), test2 * 0);
					// System.out.println(a);
					//
					// System.out.println(series2);
					//
					// System.out.println(a);
					// try {
					// series2.getData().add(a);
					// } catch (Exception e) {
					// System.out.println("Nicht so cool");
					// }
					//
					// }
					// if (counter > series.getData().size()) {
					// com.sun.javafx.application.PlatformImpl.tkExit();
					// Platform.exit();
					// }
					counter++;
					System.out.println("Ich bin ein Thread");

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
}
