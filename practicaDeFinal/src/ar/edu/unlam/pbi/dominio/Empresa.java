package ar.edu.unlam.pbi.dominio;

public class Empresa {

	/*
	 * Identificar e incorporar los atributos necesarios.
	 */
	private String nombre;
	private final int CANTIDAD_DE_PRODUCTOS= 20;
	private Producto productos[];
	private final int CANTIDAD_DE_VENTAS= 100;
	private Venta ventas[];
	private int cantidadDeVentas;
	private double contadorImporte = 0.0;
	private int cantidadDeProductosActual;

	public Empresa(String nombre) {
		/*
		 * Costructor de la clase.
		 */
		this.nombre=nombre;
		this.productos= new Producto[CANTIDAD_DE_PRODUCTOS];
		this.ventas= new Venta[CANTIDAD_DE_VENTAS];
	}
	
	public String getNombre() {
		/*
		 * Devuelve el nombre de la empresa.
		 */
		return this.nombre;
	}
	
	public double getContadorImporte() {
		return contadorImporte;
	}


	public int getCantidadDeVentas() {
		return cantidadDeVentas;
	}
	
	public void agregarProducto(Producto nuevo) { // OJO , HAY QUE CORTAR EL CICLO CON EL BOOLEAN! SINO SE REPITE SIEMPRE LA VENTA HASTA SU TOTALIDAD
		/*
		 * Agrega un producto al catalogo
		 */
		
		boolean sePuede=true;
		
		for (int i = 0; i < productos.length; i++) {
			if(productos[i]== null && sePuede==true) {
				productos[i]=nuevo;
				sePuede=false;
				cantidadDeProductosActual++;
			}
		}
	}
	
	public void realizarVenta(Venta nueva) { // OJO , HAY QUE CORTAR EL CICLO CON EL BOOLEAN! SINO SE REPITE SIEMPRE LA VENTA HASTA SU TOTALIDAD XQ TODOS SON NULL AL UNICIAR
		/*
		 * Registra una venta
		 */
		boolean vendido=true;
		
		for (int i = 0; i < ventas.length; i++) {
			if(ventas[i]== null && vendido==true) {
				ventas[i]=nueva;
				cantidadDeVentas++;
				vendido=false;
				
			}
		}
	}

	public Producto getProductoPorNombre(String nombreDelProducto) { // la busqueda es por CASILLAS LLENAS ENTONCES TIENE QUE BUSCAR DIF DE NULL
		/*
		 * Busca y devuelve un producto basado en su nombre			// EVITAR EL NULL AL RECORRER PARA RECOLECTAR DATOS
		 */
		for (int i = 0; i < cantidadDeProductosActual; i++) {
			if(productos[i] != null) {
				if( productos[i].getDescripcion().equalsIgnoreCase(nombreDelProducto)) {
					return productos[i];
				}
			}
		}
		return null;
	}
	
	public double getImportePromedioDeVentas() { // EVITAR EL NULL AL RECORRER PARA RECOLECTAR DATOS
		/*
		 * Busca y devuelve un producto basado en su importe
		 */
		
	
		for (int i = 0; i < cantidadDeVentas; i++) {
			
			if(ventas[i] != null) {
				
				contadorImporte += ventas[i].getImporteTotal();
			
				
			}
		}
		return (contadorImporte/cantidadDeVentas);
		

	}
	
	public void ordenarLosProductosPorCodigo() {
		/*
		 * Ordena el catalogo de productos por codigo
		 */

		    //  MAS ALTA - ORDENAMIENTO
		        Producto auxiliar;
		        for(int i = 0; i < cantidadDeProductosActual; i ++) {
		            for( int j = 1; j < cantidadDeProductosActual; j++) {
		                if (productos[j].getCodigo() < productos[j - 1].getCodigo()) {
		                    auxiliar = productos[j];
		                    productos[j] = productos[j-1];
		                    productos[j-1] = auxiliar;
		                }
		            }
		        }    
	}
	
	
	public String toString() {
		/*
		 * Devuelve un listado con el catalogo de productos 
		 * 
		 */
		
		String resultado = "CATALOGO DE PRODUCTOS:\n";

		for (int i = 0; i < productos.length; i++) {

				if (productos[i] != null) { //      EVITAR EL NULL AL RECORRER EL ARRAY PARA RECOLECTAR DATOS
					resultado += productos[i].getDescripcion();
					resultado += "\n";
				}
		}
		return resultado;	
	}

}
