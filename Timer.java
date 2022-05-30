package tpe;

public class Timer {

	private double startTime;

	public Timer() {
		startTime = 0;
	}

	public void start() {
		startTime = System.nanoTime();
	}

	/**
	 * Detiene el temporizador
	 * 
	 * @return el tiempo, en milisegundos, transcurrido entre que se inicio y se
	 *         detuvo el temporizador.
	 */

	public double stop() {
		double stopTime = System.nanoTime();
		return (stopTime - startTime) / 1000000.0;
	}
}
