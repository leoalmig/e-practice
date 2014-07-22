package models.analisadorSemantico;

import models.TabelaDeSimbolos;
import models.analisadorLexico.Lexer;

import java.util.ArrayList;

public class GerenciadorSemantico {
    private TabelaDeSimbolos tabelaDeSimbolos;
    private Lexer lexer;
    private ArrayList<String> tokens;

    public GerenciadorSemantico(TabelaDeSimbolos tabelaDeSimbolos) {
        this.tabelaDeSimbolos = tabelaDeSimbolos;
        lexer = new Lexer();
        tokens = new ArrayList<String>();
    }

    public void identificaDeclaracao(String sentenca) {
        tokens = lexer.tokenizar(sentenca);
        if (tokens.get(0).equals("var")) {
            tabelaDeSimbolos.adicionaSimbolo(tokens.get(1), tokens.get(3));
        }
    }
}