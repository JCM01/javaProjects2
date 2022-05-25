package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the familia database table.
 * 
 */
@Entity
@NamedQuery(name="Familia.findAll", query="SELECT f FROM Familia f")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idfamilia;

	private String familia;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="familia")
	private List<Animal> animals;
	
	
	public Familia(int idfamilia, String familia, List<Animal> animals) {
		super();
		this.idfamilia = idfamilia;
		this.familia = familia;
		this.animals = animals;
	}

	public Familia() {
	}

	public int getIdfamilia() {
		return this.idfamilia;
	}

	public void setIdfamilia(int idfamilia) {
		this.idfamilia = idfamilia;
	}

	public String getFamilia() {
		return this.familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setFamilia(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setFamilia(null);

		return animal;
	}

	@Override
	public String toString() {
		return "Familia [idfamilia=" + idfamilia + ", familia=" + familia + ", animals=" + animals + "]";
	}

	
	

}