package br.com.fiap.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.bean.Pedido;

public class TestePedido {

	public static void main(String[] args) {

		// Instaciar um pedido
		Pedido pedido = new Pedido();

		// API de Reflection para obter a estrutura da classe
		// Obter o nome da classe
		String nome = pedido.getClass().getName();
		System.out.println(nome);

		System.out.println("MÉTODOS:");
		// Obter os métodos da classe
		Method[] metodos = pedido.getClass().getDeclaredMethods();
		// Exibir o nome dos métodos
		for (Method m : metodos) {
			System.out.println(m.getName());
		}

		System.out.println("ATRIBUTOS:");
		// Obter os atributos da classe
		Field[] atributos = pedido.getClass().getDeclaredFields();

		// Exibir o nome dos atributos
		for (Field f : atributos) {

			// Acessar o valor do atributo
			try {
				f.setAccessible(true);
				System.out.println(f.get(pedido));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.println(f.getName() + " " + f.getType());
			// Obter a anotação @Coluna
			Coluna anotacao = f.getAnnotation(Coluna.class);
			// Exibir os parametros da anotação Coluna
			System.out.println(anotacao.nome() + " " + anotacao.tamanho() + " " + anotacao.unico());
		}
	}

}
