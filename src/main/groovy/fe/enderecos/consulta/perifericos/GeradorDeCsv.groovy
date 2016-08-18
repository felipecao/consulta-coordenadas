package fe.enderecos.consulta.perifericos

import java.nio.file.Paths

class GeradorDeCsv {
    void criarArquivoDeSaida(List<LinhaDoArquivo> linhasDeSaida, String nomeDoArquivoDeSaida) {
        Paths.get(nomeDoArquivoDeSaida).withWriter { out ->
            escreveCabecalho(out)

            linhasDeSaida.each { l ->
                escreveLinha(out, l)
            }
        }
    }

    private escreveCabecalho(Writer out) {
        out.println("Cidade;Bairro;Tipo Logradouro;Logradouro;Numero;Latitude;Longitude")
    }

    private escreveLinha(Writer out, LinhaDoArquivo l) {
        out.println("${l.cidade};${l.bairro};${l.tipoDeLogradouro};${l.logradouro};${l.numero};'${l.coordenadas.latitude};'${l.coordenadas.longitude}")
    }

}
