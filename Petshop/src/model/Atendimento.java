package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Atendimento {

	private int codigo;
	private Animal animal;
	private Servico servico;
	private Date date;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Atendimento() {}

	public Atendimento(int codigo, Animal animal, Servico servico, Date date) {
		this.codigo = codigo;
		this.animal = animal;
		this.servico = servico;
		this.date = date;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return (
			"Atendimento - Código: " +
			codigo +
			", Animal: " +
			animal.getCodigo() +
			", Servico: " +
			servico.getCodigo() +
			", Data: " +
			sdf.format(date)
		);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((sdf == null) ? 0 : sdf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Atendimento other = (Atendimento) obj;
		if (codigo != other.codigo) return false;
		if (animal == null) {
			if (other.animal != null) return false;
		} else if (!animal.equals(other.animal)) return false;
		if (servico == null) {
			if (other.servico != null) return false;
		} else if (!servico.equals(other.servico)) return false;
		if (date == null) {
			if (other.date != null) return false;
		} else if (!date.equals(other.date)) return false;
		if (sdf == null) {
			if (other.sdf != null) return false;
		} else if (!sdf.equals(other.sdf)) return false;
		return true;
	}
}
