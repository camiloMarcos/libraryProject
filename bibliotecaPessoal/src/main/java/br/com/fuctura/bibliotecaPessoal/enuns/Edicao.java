package br.com.fuctura.bibliotecaPessoal.enuns;

public enum Edicao {
    PRIMEIRA (0),
    SEGUNDA (1),
    TERCEIRA(2);

    private final int codigo;

    Edicao(int cod){
        this.codigo = cod;
    }

    public int getCodigo() {
        return codigo;
    }
}
