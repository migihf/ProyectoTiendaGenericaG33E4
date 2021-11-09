package mintic.edu.g33.e4.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;


//anotaciones
@Entity
public class Producto {
	//atributos tabla
	@Id
	@Size(min=2,max=20)
	private int codigo_producto;
	
	@NotEmpty
	@Size(min=5,max=50)
	private String nombre_producto;
	
	@Min(value=8)
	@Max(value=20)
	private int nitproveedor;
	
	private double precio_compra;
	
	@Min(value=0)
	@Max(value=19)
	private double ivacompra;
	
	private double precio_venta;

	public Producto(@Size(min = 2, max = 20) int codigo_producto,
			@NotEmpty @Size(min = 5, max = 50) String nombre_producto, @Min(8) int nitproveedor, double precio_compra,
			@Min(19) @Max(35) double ivacompra, double precio_venta) {
		this.codigo_producto = codigo_producto;
		this.nombre_producto = nombre_producto;
		this.nitproveedor = nitproveedor;
		this.precio_compra = precio_compra;
		this.ivacompra = ivacompra;
		this.precio_venta = precio_venta;
	}

	public Producto() {
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	@Override
	public String toString() {
		return "Productos [codigo_producto=" + codigo_producto + ", nombre_producto=" + nombre_producto
				+ ", nitproveedor=" + nitproveedor + ", precio_compra=" + precio_compra + ", ivacompra=" + ivacompra
				+ ", precio_venta=" + precio_venta + "]";
	}
	
		
}
