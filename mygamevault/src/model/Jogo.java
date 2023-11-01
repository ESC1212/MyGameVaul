package model;

public class Jogo extends player{
public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public Float getNota() {
		return nota;
	}
	public void setNota(Float nota) {
		this.nota = nota;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getConctot() {
		return conctot;
	}
	public void setConctot(int conctot) {
		this.conctot = conctot;
	}
private String Nome;
private String ano;
private Float nota;
private String desc;
private int conctot;
private String genero;

	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
