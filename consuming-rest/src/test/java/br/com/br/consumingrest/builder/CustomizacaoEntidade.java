package br.com.br.consumingrest.builder;


public interface CustomizacaoEntidade<E> {

    void executar(E entidade);

}