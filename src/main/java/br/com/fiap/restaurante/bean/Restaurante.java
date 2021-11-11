package br.com.fiap.restaurante.bean;

import java.util.Calendar;

public class Restaurante {

		private int codigo;
		
		private String nome;
		
		private String cnpj;
		
		private Calendar dataInauguracao;
		
		private String categoria;
		
		public Restaurante() {
			super();
		}

		public Restaurante(int codigo, String nome, String cnpj, Calendar dataInauguracao, String categoria) {
			super();
			this.codigo = codigo;
			this.nome = nome;
			this.cnpj = cnpj;
			this.dataInauguracao = dataInauguracao;
			this.categoria = categoria;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public Calendar getdataInauguracao() {
			return dataInauguracao;
		}

		public void setdataInauguracao(Calendar dataInauguracao) {
			this.dataInauguracao = dataInauguracao;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		
	}