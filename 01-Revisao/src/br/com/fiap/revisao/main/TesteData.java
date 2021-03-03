package br.com.fiap.revisao.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {

	public static void main(String[] args) {

		// Instanciar um objeto de data com a data atual
		Calendar hoje = Calendar.getInstance();

		// Instanciar um objeto de data com a data da entrega da challenge
		Calendar challenge = new GregorianCalendar(2021, Calendar.MAY, 15);

		// Formatador de data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		// Exibir a data
		System.out.println(sdf.format(hoje.getTime()));

		System.out.println(sdf.format(challenge.getTime()));
	}

}
