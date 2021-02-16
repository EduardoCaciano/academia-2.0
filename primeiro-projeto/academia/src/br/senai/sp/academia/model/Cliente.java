package br.senai.sp.academia.model;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {

	private String nome;
	private double peso;
	private double altura;
	private LocalDate dataDeNascimento;
	private char sexo;
	private int nivelDeAtividade;

	// Nome
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	// Peso
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPeso() {
		return this.peso;
	}

	// Altura
	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAltura() {
		return this.altura;
	}

	// Data de Nascimento
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public LocalDate getDataDeNascimento() {
		return this.dataDeNascimento;
	}

	// Sexo
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setNivelDeAtividade(int nivelDeAtividade) {
		if (nivelDeAtividade == 0) {
			this.nivelDeAtividade = 0;
		} else {
			if (nivelDeAtividade == 1) {
				this.nivelDeAtividade = 1;
			} else {
				if (nivelDeAtividade == 2) {
					this.nivelDeAtividade = 2;
				} else {
					if (nivelDeAtividade == 3) {
						this.nivelDeAtividade = 3;
					}
				}
			}
		}
	}

	public int getNivelDeAtividade() {
		return this.nivelDeAtividade;
	}

	// Nivel de atividade Masculino
	public static final String LEVEMASC = ("1.5");
	public static final String MODERADOMASC = ("1.8");
	public static final String INTENSOMASC = ("2.1");

	// Nivel de atividade Feminino
	public static final String LEVEFEM = ("1.6");
	public static final String MODERADOFEM = ("1.6");
	public static final String INTENSOFEM = ("1.8");

	public int getIdade() {
		LocalDate dataDeHoje = LocalDate.now();
		Period comparacaoData = Period.between(dataDeNascimento, dataDeHoje);
		return comparacaoData.getYears();
	}

//	Calcular IMC do Cliente
	public double getCalcularImc() {
		return this.peso / Math.pow(this.altura, 2);
	}

	public String getStatusImc() {
		if (this.getCalcularImc() < 18.5) {
			return "Abaixo do peso";
		} else if (this.getCalcularImc() > 18.6 && this.getCalcularImc() < 24.9) {
			return "Peso ideal";
		} else if (this.getCalcularImc() > 25 && this.getCalcularImc() < 29.9) {
			return "Levemente acima do peso";
		} else if (this.getCalcularImc() > 30 && this.getCalcularImc() < 34.9) {
			return "Obesidade grau I";
		} else if (this.getCalcularImc() > 35 && this.getCalcularImc() < 39.9) {
			return "Obesidade grau II";
		} else {
			return "Obesidade III (Morbita)";
		}
	}

	public double getNcd() {
		// Ncd Masculino
		if (this.sexo == 'm') {

			if (this.nivelDeAtividade == 0) {
				if (getIdade() >= 18 && getIdade() <= 30) {
					return 15.3 * this.peso + 679;
				} else if (getIdade() >= 31 && getIdade() <= 60) {
					return 11.6 * this.peso + 879;
				} else if (getIdade() >= 60) {
					return 13.5 * this.peso + 487;
				} else {
					return 0;
				}

				// Atividade Leve
			} else if (this.nivelDeAtividade == 1) {
				if (getIdade() >= 18 && getIdade() <= 30) {
					return (15.3 * this.peso + 679) * 1.5;
				} else if (getIdade() >= 31 && getIdade() <= 60) {
					return (11.6 * this.peso + 879) * 1.5;
				} else if (getIdade() >= 60) {
					return (13.5 * this.peso + 487) * 1.5;
				} else {
					return 0;
				}

				// Atividade Moderado
			} else if (this.nivelDeAtividade == 2) {
				if (getIdade() >= 18 && getIdade() <= 30) {
					return (15.3 * this.peso + 679) * 1.8;
				} else if (getIdade() >= 31 && getIdade() <= 60) {
					return (11.6 * this.peso + 879) * 1.8;
				} else if (getIdade() >= 60) {
					return (13.5 * this.peso + 487) * 1.8;
				} else {
					return 0;
				}

				// Atividade Intenso
			} else if (this.nivelDeAtividade == 3) {
				if (getIdade() >= 18 && getIdade() <= 30) {
					return (15.3 * this.peso + 679) * 2.1;
				} else if (getIdade() >= 31 && getIdade() <= 60) {
					return (11.6 * this.peso + 879) * 2.1;
				} else if (getIdade() >= 60) {
					return (13.5 * this.peso + 487) * 2.1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}

			// Ncd Feminino
		} else if (this.sexo == 'f') {

			if (this.nivelDeAtividade == 0) {
				if (getIdade() >= 18 && getIdade() <= 30) {
					return 14.7 * this.peso + 496;
				} else if (getIdade() >= 31 && getIdade() <= 60) {
					return 8.7 * this.peso + 829;
				} else if (getIdade() >= 60) {
					return 10.5 * this.peso + 596;

					// Atividade Leve
				} else if (this.nivelDeAtividade == 1) {
					if (getIdade() >= 18 && getIdade() <= 30) {
						return (14.7 * this.peso + 496) * 1.6;
					} else if (getIdade() >= 31 && getIdade() <= 60) {
						return (8.7 * this.peso + 829) * 1.6;
					} else if (getIdade() >= 60) {
						return (10.5 * this.peso + 596) * 1.6;

						// Atividade Moderado
					} else if (this.nivelDeAtividade == 2) {
						if (getIdade() >= 18 && getIdade() <= 30) {
							return (14.7 * this.peso + 496) * 1.6;
						} else if (getIdade() >= 31 && getIdade() <= 60) {
							return (8.7 * this.peso + 829) * 1.6;
						} else if (getIdade() >= 60) {
							return (10.5 * this.peso + 596) * 1.6;
							
							// Atividade Intenso
						} else if (this.nivelDeAtividade == 3) {
							if (getIdade() >= 18 && getIdade() <= 30) {
								return (14.7 * this.peso + 496) * 1.8;
							} else if (getIdade() >= 31 && getIdade() <= 60) {
								return (8.7 * this.peso + 829) * 1.8;
							} else if (getIdade() >= 60) {
								return (10.5 * this.peso + 596) * 1.8;
							} else {
								return 0;
							}
						} else {
							return 0;
						}
					} else {
						return 0;
					}
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

}
