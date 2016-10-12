package fe.enderecos.consulta.perifericos

import org.apache.commons.csv.CSVParser

import java.nio.file.Paths

import static fe.enderecos.consulta.perifericos.GeradorDeLogs.log
import static org.apache.commons.csv.CSVFormat.*

class LeitorDeCsv {
    List<LinhaDoArquivo> lerArquivo(String nomeDoArquivo) {

        log("To lendo esse arquivo aqui, oh: ${nomeDoArquivo}")

        def linhas = []

        Paths.get(nomeDoArquivo).withReader { reader ->
            CSVParser csv = new CSVParser(reader, DEFAULT.withHeader().withDelimiter(';'.charAt(0)))

            csv.iterator().each { record ->
                linhas << new LinhaDoArquivo(
                        id: record."Id",
                        cidade: record."Cidade",
                        logradouro: record."Logradouro" - "Rua ",
                        tipoDeLogradouro: record."Tipo Logradouro",
                        numero: record."Numero",
                        bairro: record."Bairro"
                )
            }
        }

        log("Terminei de ler o tal do ${nomeDoArquivo}")

        return linhas
    }
}
