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
	private Textbox txtbxMaiuscula;

	@Wire
	private Listbox lstbxOperacoesRealizadas;

	private ArrayList<LinkedHashMap<String, String>> listaOperacoes = new ArrayList<LinkedHashMap<String, String>>();

	// Metodo que ira ser acionado ao clicar no btnMaiuscula //
	@Listen("onClick = #btnMaiuscula")
	public void trocarPorMaiuscula() {
		String antes = this.txtbxMaiuscula.getValue(); // Aqui ele pega o valor
														// inserido
		String depois = antes.toUpperCase(); // Aqui ele modifica o valor
		this.txtbxMaiuscula.setValue(depois); // Aqui ele seta o valor
												// modificado

		LinkedHashMap<String, String> hash = new LinkedHashMap<String, String>();
		hash.put("operacoes", "Maiúscula");
		hash.put("antes", antes); // Aqui ele mostra o valor anterior
		hash.put("depois", depois); // O valor modificado
		listaOperacoes.add(hash); // Adiciona a lista

		this.lstbxOperacoesRealizadas.setModel(new ListModelArray<LinkedHashMap<String, String>>(this.listaOperacoes));
	}

	// Aqui ele ira vincular o botão com a textbox //
	@Wire
	private Textbox txtbxMinusculo;

	@Listen("onClick = #btnMinusculo")
	public void trocarPorMinuscula() {
		String antes = this.txtbxMinusculo.getValue();
		String depois = antes.toLowerCase();
		this.txtbxMinusculo.setValue(depois);

		LinkedHashMap<String, String> hash = new LinkedHashMap<String, String>();
		hash.put("operacoes", "Minúscula");
		hash.put("antes", antes);
		hash.put("depois", depois);
		listaOperacoes.add(hash);

		this.lstbxOperacoesRealizadas.setModel(new ListModelArray<LinkedHashMap<String, String>>(this.listaOperacoes));
	}

}