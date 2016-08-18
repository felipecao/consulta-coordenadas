package fe.enderecos.consulta.perifericos

import groovyx.net.http.RESTClient

import static fe.enderecos.consulta.perifericos.GeradorDeLogs.log
import static groovyx.net.http.ContentType.JSON

class ApiGoogleMaps {

    private RESTClient client

    ApiGoogleMaps() {
        client = new RESTClient("https://maps.googleapis.com/maps/api/geocode/json")
    }

    Coordenadas pesquisarCoordenadasParaEndereco(LinhaDoArquivo linhaDoArquivo) {

        log("To pesquisando as coordenadas pra esse endereco: ${linhaDoArquivo.tipoDeLogradouro} ${linhaDoArquivo.logradouro} ${linhaDoArquivo.numero}, ${linhaDoArquivo.cidade}")

        String endereco = "${linhaDoArquivo.tipoDeLogradouro} ${linhaDoArquivo.logradouro} ${linhaDoArquivo.numero}, ${linhaDoArquivo.cidade}, Brazil".toLowerCase().replace(" ", "+")
        RESTClient client = new RESTClient("https://maps.googleapis.com/maps/api/geocode/json?address=" + endereco)
        def json = client.get([
                requestContentType: JSON
        ])

        log("Achei as danadas das coordenadas pro endereco ${linhaDoArquivo.tipoDeLogradouro} ${linhaDoArquivo.logradouro} ${linhaDoArquivo.numero}, ${linhaDoArquivo.cidade}")

        return new Coordenadas(
                latitude: json.responseData.results.geometry.location.lat[0],
                longitude: json.responseData.results.geometry.location.lng[0],
        )
    }
}
