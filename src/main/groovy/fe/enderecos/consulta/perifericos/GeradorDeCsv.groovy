package fe.enderecos.consulta.perifericos

import java.nio.file.Paths

class GeradorDeCsv {
    void criarArquivoDeSaida(List<LinhaDoArquivo> linhasDeSaida, String nomeDoArquivoDeSaida) {
        Paths.get(nomeDoArquivoDeSaida).withWriter { out ->

            escreverCabecalho(out)

            linhasDeSaida.each { l ->
                escreverLinha(out, l)
            }
        }
    }

    private escreverCabecalho(Writer out) {
        out.println("Cidade;Bairro;Tipo Logradouro;Logradouro;Numero;Latitude;Longitude")
    }

    private escreverLinha(Writer out, LinhaDoArquivo l) {
        out.println("${l.id};${l.cidade};${l.bairro};${l.tipoDeLogradouro};${l.logradouro};${l.numero};'${l.coordenadas.latitude};'${l.coordenadas.longitude}")
    }

}
