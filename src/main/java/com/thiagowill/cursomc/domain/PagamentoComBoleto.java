package com.thiagowill.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.thiagowill.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagemento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date dataVencimento) {
		super(id, estado, pedido);
		this.dataPagemento =  dataPagamento;
		this.dataVencimento =  dataVencimento;
		
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagemento() {
		return dataPagemento;
	}

	public void setDataPagemento(Date dataPagemento) {
		this.dataPagemento = dataPagemento;
	}
	
	
}
