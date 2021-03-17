package br.com.fiap.tds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Teste.java - compilar -> Testee.class (bytecode) - > Interpretar (JVM)

//Definbe onde a anotação pode ser utilizada
@Target({ ElementType.FIELD, ElementType.METHOD })

@Retention(RetentionPolicy.RUNTIME)
//SOURCE -> até o código
//CLASS - > até  compilação
//RUNTIME -> até a execução

public @interface Coluna {

	String nome(); // parâmetro da anotação

	int tamanho() default 255;

	boolean unico() default false;

}
