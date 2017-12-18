package a2;

import java.io.Serializable;
import java.util.Date;

public class Albaranes implements Serializable{

	private static final long serialVersionUID = 1L;
	private int albaran;
	private String estado;
	private int cliente;
	private String formpago;
	private String fecha_albaran;
	private String fecha_envio;
	private String fecha_pago;
	
	//Todo lo relacionado con el numero de albaran.
	public int getAlbaran() {
		return albaran;
	}

	public void setAlbaran(int albaran) {
		this.albaran = albaran;
	}

	//Todo lo relacionado con el estado del albaran.
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	//Todo lo relacionado con el cliente del albaran.
	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	//Todo lo relacionado con el pago del albaran.
	public String getPago() {
		return formpago;
	}

	public void setPago(String formpago) {
		this.formpago = formpago;
	}
	
	
	//Todo lo relacionado con las fechas.
	
	//Fecha del albaran pedido
	
	public String getFecha(){
		return fecha_albaran;
	}
	
	public void setFecha(String fecha_albaran){
		this.fecha_albaran=fecha_albaran;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}