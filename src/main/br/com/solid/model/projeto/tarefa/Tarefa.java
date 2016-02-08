package main.br.com.solid.model.projeto.tarefa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarefa {

	private DetalhesTarefa detalhes;
	private Responsaveis responsaveis;
	private DetalhesProgressoTarefa detalhesProgressoTarefa;
	private Impedimento impedimento;
	private DetalhesTestesTarefa detalhesTestesTarefa;
	private LocalDate dataFimDesenvolvimento;
	private LocalDateTime dataFinalizacao;
	private Cancelamento cancelamento;
	
	protected Tarefa() {
		this.detalhes = new DetalhesTarefa();
		this.responsaveis = new Responsaveis();
		this.detalhesProgressoTarefa = new DetalhesProgressoTarefa();
		this.detalhesTestesTarefa = new DetalhesTestesTarefa();
	}
	
	public DetalhesTarefa getDetalhes() {
		return detalhes;
	}
	
	public Responsaveis getResponsaveis() {
		return responsaveis;
	}
	
	public DetalhesProgressoTarefa getDetalhesProgressoTarefa() {
		return detalhesProgressoTarefa;
	}

	public Impedimento getImpedimento() {
		return impedimento;
	}
	
	public DetalhesTestesTarefa getDetalhesTestesTarefa() {
		return detalhesTestesTarefa;
	}
	
	public void impede(Impedimento impedimento) {
		this.impedimento = impedimento;
	}
	
	public Cancelamento getCancelamento() {
		return cancelamento;
	}
	
	public void cancela(Cancelamento cancelamento) {
		this.cancelamento = cancelamento;
	}

	public LocalDate getDataFimDesenvolvimento() {
		return dataFimDesenvolvimento;
	}

	public void setFimDesenvolvimento(LocalDate dataFimDesenvolvimento) {
		this.dataFimDesenvolvimento = dataFimDesenvolvimento;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	@Override
	public String toString() {
		return getDetalhes().getTitulo();
	}

	public void definePrioridade(Prioridade bloqueador) {
		getDetalhes().setPrioridade(bloqueador);
	}

}
