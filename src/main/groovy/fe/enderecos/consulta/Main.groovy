package fe.enderecos.consulta

class Main {

    static String NOME_DO_ARQUIVO_DE_ENTRADA = 'enderecos.csv'
    static String NOME_DO_ARQUIVO_DE_SAIDA = 'enderecos_com_coordenadas.csv'

    PesquisadorDeEnderecos pesquisador

    static void main(def args) {
        Main m = new Main()

        m.instanciarPesquisador(args)
        m.lerEnderecosDeArquivoCSV()

        System.exit(0)
    }

    void instanciarPesquisador(def args) {
        if (!args) {
            pesquisador = new PesquisadorDeEnderecos(NOME_DO_ARQUIVO_DE_ENTRADA, NOME_DO_ARQUIVO_DE_SAIDA)
        } else {
            pesquisador = new PesquisadorDeEnderecos(args[0], args[1])
        }
    }

    private void lerEnderecosDeArquivoCSV() {
        pesquisador.pesquisar()
    }
}
