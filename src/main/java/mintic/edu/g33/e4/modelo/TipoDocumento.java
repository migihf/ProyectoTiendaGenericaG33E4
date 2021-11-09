package mintic.edu.g33.e4.modelo;

import javax.persistence.*;

@Entity
@Table(name= TipoDocumento.TABLE_NAME)
public class TipoDocumento {
	
	public static final String TABLE_NAME="tipodocumento";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo")
	private String tipo;

	public TipoDocumento() {
	}

	public TipoDocumento(Long id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
