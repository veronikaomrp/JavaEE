package del.ac.id.demo.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	private Long flightid;
	private String date;
	private String tujuan;
	private String maskapai;
	
	public Flight() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getFlightid() {
		return flightid;
	}

	public void setFlightid(Long flightid) {
		this.flightid = flightid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTujuan() {
		return tujuan;
	}

	public void setTujuan(String tujuan) {
		this.tujuan = tujuan;
	}

	public String getMaskapai() {
		return maskapai;
	}

	public void setMaskapai(String maskapai) {
		this.maskapai = maskapai;
	}
	

}
