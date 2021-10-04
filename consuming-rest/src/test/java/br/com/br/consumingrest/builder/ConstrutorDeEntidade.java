package br.com.br.consumingrest.builder;


import java.text.ParseException;

public abstract class ConstrutorDeEntidade<E> {

    private CustomizacaoEntidade<E> customizacao;

    public E construir() throws ParseException {
        final E entidade = construirEntidade();
        if (isCustomizado()) {
            customizacao.executar(entidade);
            setCustomizacao(null);
        }
        return persistir(entidade);
    }

    /**
     * Este método permite a customização dos atributos da entidade antes da
     * persistência
     *
     * @param customizacao customizacao
     * @return entidade customizada
     */
    public ConstrutorDeEntidade<E> customizar(CustomizacaoEntidade<E> customizacao) {
        this.customizacao = customizacao;
        return this;
    }

    /**
     * Este método deve retornar uma instância da entidade inicializada com os dados
     * padrão para todos os testes.
     *
     * @return entidade construída
     */
    public abstract E construirEntidade() throws ParseException;

    /**
     * Este método deve persistir e retornar a entidade recebida no parametro
     * <b>entidade</b>
     *
     * @param entidade entidade
     * @return entidade persistida
     */
    protected abstract E persistir(E entidade) throws ParseException;

    /**
     * Este método deve persistir e retornar a entidade recebida no parametro
     * <b>entidade</b>
     *
     * @param id id
     * @return entidade persistida
     */
    public abstract E obterPorId(Long id);

    /**
     * Is customizado boolean.
     *
     * @return boolean
     */
    public boolean isCustomizado() {
        return this.customizacao != null;
    }

    public void setCustomizacao(CustomizacaoEntidade<E> customizacao) {
        this.customizacao = customizacao;
    }
}
