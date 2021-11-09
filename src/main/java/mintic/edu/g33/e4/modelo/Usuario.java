package mintic.edu.g33.e4.modelo;

import javax.persistence.*;

@Entity
@Table(name="Usuario.TABLE_NAME")
public class Usuario {
	public static final String TABLE_NAME="usuario";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idTipoDocumento")
	private TipoDocumento idTipoDocumento;
	
	@Column(name="numDocumento")
	private String numDocumento;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="psswrd")
	private String psswrd;
	
	@Column(name="nombreUsuario")
	private String nombreUsuario;
	
	@Column(name="email")
	private String email;

	public Usuario(Long id, TipoDocumento idTipoDocumento, String numDocumento, String nombre, String psswrd,
			String nombreUsuario, String email) {
		this.id = id;
		this.idTipoDocumento = idTipoDocumento;
		this.numDocumento = numDocumento;
		this.nombre = nombre;
		this.psswrd = psswrd;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
	}

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPsswrd() {
		return psswrd;
	}

	public void setPsswrd(String psswrd) {
		this.psswrd = psswrd;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
