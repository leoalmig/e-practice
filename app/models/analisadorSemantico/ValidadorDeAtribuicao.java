        package models.analisadorSemantico;

        import models.TabelaDeSimbolos;
        import models.Validador;
        import models.analisadorLexico.IdentificadorDeToken;
        import models.analisadorLexico.Lexer;
        import models.analisadorSintatico.ValidadorDeDeclaracaoDeVariavel;


        import java.util.ArrayList;

        /**
         * Created by alunos4 on 21/07/14.
         */
        public class ValidadorDeAtribuicao implements Validador{
            IdentificadorDeToken identificadorDeToken;
            TabelaDeSimbolos tabelaDeSimbolos;

            ArrayList<String> tokens;

            public ValidadorDeAtribuicao(TabelaDeSimbolos tabelaDeSimbolos, ArrayList<String> tokens){
                this.tabelaDeSimbolos = tabelaDeSimbolos;
                this.tokens = tokens;
                this.identificadorDeToken = new IdentificadorDeToken();
            }

            public boolean validaVariavel(){
                boolean retorno = false;
                if(tabelaDeSimbolos.simboloExiste(tokens.get(0))){
                    retorno = true;
                }
                return retorno;
            }

            public boolean validaExpressao(){
                boolean retorno;
                if((identificadorDeToken.verificaSeTodasOsCaracteresSaoNumeros(tokens.get(2))
                   && tabelaDeSimbolos.verificaSeTipoCombina(tokens.get(0),"Inteiro"))
                   || ((identificadorDeToken.identifica(tokens.get(2)) == "CONSTANTE_TIPO_STRING")
                   && tabelaDeSimbolos.verificaSeTipoCombina(tokens.get(0),"String"))){
                    retorno = true;
                }else{
                    retorno = false;
                }
                return retorno;
            }



            @Override
            public boolean valida(ArrayList<String> tokens) {
                return false;
            }

            @Override
            public String retornaMensagemErro() {
                return null;
            }
        }