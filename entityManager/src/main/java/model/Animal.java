package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idanimal;

	private String animal;

	private int cuentos;

	//bi-directional many-to-one association to Familia
	@ManyToOne
	@JoinColumn(name="idfamilia")
	private Familia familia;
	
	public Animal(int idanimal, String animal, int cuentos, Familia familia) {
		super();
		this.idanimal = idanimal;
		this.animal = animal;
		this.cuentos = cuentos;
		this.familia = familia;
	}

	public Animal() {
	}

	public int getIdanimal() {
		return this.idanimal;
	}

	public void setIdanimal(int idanimal) {
		this.idanimal = idanimal;
	}

	public String getAnimal() {
		return this.animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public int getCuentos() {
		return this.cuentos;
	}

	public void setCuentos(int cuentos) {
		this.cuentos = cuentos;
	}

	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Override
	public String toString() {
		return "Animal [idanimal=" + idanimal + ", animal=" + animal + ", cuentos=" + cuentos + ", familia=" + familia
				+ "]";
	}
	
	

}