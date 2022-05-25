package actividades.uno;

/**
 * Clase que define las propiedades
 * de Planeta
 * 
 * @author amna
 * @version 1.0
 */
public class Planeta {
	private int id;
	private String nombre;
	private double radio;
	private double densidad;
	private double velocidad;

	/**
	 * Constructor principal de la clase para los objetos tipo Planeta
	 * 
	 * @param id        identificador único de cada planeta
	 * @param nombre    nombre del planeta
	 * @param radio     radio del planeta (km)
	 * @param densidad  densidad del planeta (g/cm^3)
	 * @param velocidad velocidad de escape (km/s)
	 */
	public Planeta(int id, String nombre, double radio, double densidad, double velocidad) {
		this.id = id;
		this.nombre = nombre;
		this.radio = radio;
		this.densidad = densidad;
		this.velocidad = velocidad;
	}
	public Planeta() {}

	@Override
	public String toString() {
		return "Planeta [id=" + id + ", nombre=" + nombre + ", radio=" + radio + ", densidad=" + densidad
				+ ", velocidad=" + velocidad + "]";
	}

	/*
	 * Getters-Setters
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getDensidad() {
		return densidad;
	}

	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

}
