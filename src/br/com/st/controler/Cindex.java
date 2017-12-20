package br.com.st.controler;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.zkoss.zhtml.Link;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelArray;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

public class Cindex extends SelectorComposer<Component> {

	/**
	 * Adicionar no controler o codigo abaixo
	 */
	private static final long serialVersionUID = 1L;

	// Aqui ele ira vincular o botão com a textbox //
	@Wire
	private Textbox txtbxAgencia;
	@Wire
	private Textbox txtbxConta;
	@Wire
	private Textbox txtbxTitular;
	@Wire
	private Textbox txtbxSaldo;

	@Wire
	private Listbox lstbxOperacoesRealizadas;

	private ArrayList<LinkedHashMap<String, String>> listaOperacoes = new ArrayList<LinkedHashMap<String, String>>();

	// Metodo que ira ser acionado ao clicar no btnMaiuscula //
	@Listen("onClick = #btnCad")
	public void addCadastro() {
		String ag = this.txtbxAgencia.getValue();
		String cc = this.txtbxConta.getValue();
		String tt = this.txtbxTitular.getValue();
		String sd = this.txtbxSaldo.getValue();

		LinkedHashMap<String, String> hash = new LinkedHashMap<String, String>();
		hash.put("agencia", ag);
		hash.put("conta", cc); // Aqui ele mostra o valor anterior
		hash.put("titular", tt);
		hash.put("saldo", sd);
		listaOperacoes.add(hash); // Adiciona a lista

		this.lstbxOperacoesRealizadas.setModel(new ListModelArray<LinkedHashMap<String, String>>(this.listaOperacoes));
	}

	// // Aqui ele ira vincular o botão com a textbox //
	// @Wire
	// private Textbox txtbxMinusculo;
	//
	// @Listen("onClick = #btnMinusculo")
	// public void trocarPorMinuscula() {
	// String antes = this.txtbxMinusculo.getValue();
	// String depois = antes.toLowerCase();
	// this.txtbxMinusculo.setValue(depois);
	//
	// LinkedHashMap<String, String> hash = new LinkedHashMap<String, String>();
	// hash.put("operacoes", "Minúscula");
	// hash.put("antes", antes);
	// hash.put("depois", depois);
	// listaOperacoes.add(hash);
	//
	// this.lstbxOperacoesRealizadas.setModel(new
	// ListModelArray<LinkedHashMap<String, String>>(this.listaOperacoes));
	// }

}