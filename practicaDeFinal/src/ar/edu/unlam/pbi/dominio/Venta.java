package ar.edu.unlam.pbi.dominio;

public class Venta{
	/*
	 * Identificar e incorporar los atributos necesarios.
	 */
	private int dni;
	private String nombreDelCliente;
	private final int CANTIDAD_DE_ARTICULOS_MAXIMA= 100;
	private Producto carrito[];
	private int cantidadDeProductos;
	
	public Venta(int dni, String nombreDelCliente)  {
		/*
		 * Costructor de la clase.
		 */
		this.dni=dni;
		this.nombreDelCliente=nombreDelCliente;
		this.carrito= new Producto[CANTIDAD_DE_ARTICULOS_MAXIMA];
	}
	
	public int getDni() {
		/*
		 * Devuelve el dni del cliente.
		 */
		return dni;

	}
	
	public String getNombrDelCliente() {
		/*
		 * Devuelve el dni del cliente.
		 */
		return nombreDelCliente;

	}
	
	public void agregarItem(Producto producto) {
		/*
		 * Agrega un producto a la venta
		 */
		boolean sePuede= true;
		
		for (int i = 0; i < carrito.length; i++) {
			if(carrito[i]== null && sePuede==true)  {
				carrito[cantidadDeProductos++]= producto;
				sePuede= false;
			}
		}

	}
	
	public int getCantidadDeProductosComprados() {
		/*
		 * Devuelve la cantidad de proctos comprados 
		 */
		return cantidadDeProductos;
	}
	
	public double getImporteTotal() {
		/*
		 * Importe total de la venta o sumatoria del precio del producto
		 */
		double costoTotal = 0.0;
		
		for (int i = 0; i < carrito.length; i++) {
			if(carrito[i]!= null) {
				costoTotal += carrito[i].getPrecio();
			}
		}
		return costoTotal;
	}
	
	public String toString() {
		
		/*
		 * Devuelve infomacion de la venta (Nombre del cliente e importe total)
		 */
		return "Cliente: " + nombreDelCliente + " importe total: " + getImporteTotal() + "";
	}

}
