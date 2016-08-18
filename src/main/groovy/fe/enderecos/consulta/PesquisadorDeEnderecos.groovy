package fe.enderecos.consulta

import fe.enderecos.consulta.perifericos.ApiGoogleMaps
import fe.enderecos.consulta.perifericos.GeradorDeCsv
import static fe.enderecos.consulta.perifericos.GeradorDeLogs.*
import fe.enderecos.consulta.perifericos.LeitorDeCsv
import fe.enderecos.consulta.perifericos.LinhaDoArquivo

class PesquisadorDeEnderecos {

    private LeitorDeCsv leitorDeCsv
    private ApiGoogleMaps googleMaps
    private GeradorDeCsv geradorDeCsv

    private String nomeDoArquivoDeEntrada
    private String nomeDoArquivoDeSaida

    PesquisadorDeEnderecos(String arquivoEntrada, String arquivoSaida) {
        leitorDeCsv = new LeitorDeCsv()
        googleMaps = new ApiGoogleMaps()
        geradorDeCsv = new GeradorDeCsv()

        nomeDoArquivoDeEntrada = arquivoEntrada
        nomeDoArquivoDeSaida = arquivoSaida
    }

    void pesquisar() {

        log("Essssttaaaa valeeennnddooo!!!")

        List<LinhaDoArquivo> linhas = leitorDeCsv.lerArquivo(nomeDoArquivoDeEntrada)
        List<LinhaDoArquivo> linhasDeSaida = []

        linhas.each {
            it.coordenadas = googleMaps.pesquisarCoordenadasParaEndereco(it)
            linhasDeSaida << it
        }

        log("Pronto, terminei de pesquisar, to gerando um arquivo CSV de saida, todo bonitao, segura ae!!!")

        geradorDeCsv.criarArquivoDeSaida(linhasDeSaida, nomeDoArquivoDeSaida)

        log("Terminou!!")
    }
}
