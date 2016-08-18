# Consulta de coordenadas
> Simplezinho, mas bonitinho

### Pra que serve?
Serve pra buscar as coordenadas de um conjunto de endereços por meio do google Maps

### Como funciona?
Tá vendo que tem um arquivo aqui chamado `enderecos.csv`? Então, basta abrir esse arquivo no Excel, colocar as informações dos endereços que tu pesquisar, rodar o programa e ele vai gerar uma cópia desse teu arquivo, com 2 colunas a mais, contendo a latitude e longitude de cada endereço.

### Como faço pra usar esse troço?
Primeiro de tudo, tu vai precisar ter o Java instalado. Normalmente, nos computadores modernos, já vem instalado. Se tu não sabe se tem ou não, basta baixar aqui, ó: https://java.com/en/download/

Já instalou o Java? Agora é mole, mole. Vamolá:

1. Baixe o `enderecos.csv`;
1. Substitua os dados que tem lá com os dados dos endereços que tu quer pesquisar;
1. Terminou de preencher o `enderecos.csv`? Agora vai lá na pasta `distribuicao` e baixa o `consulta-enderecos.jar`. O `consulta-enderecos.jar` é o programa que vai fazer tua pesquisa e gerar teus resultados. Você vai precisar colocar ambos os arquivos na mesma pasta.
1. Agora vem a parte difícil (achou que tava fácil, né?). Abra a linha de comando no seu computador, entre na pasta onde tu baixou esses arquivos, e roda o seguinte comando: `java -jar consulta-enderecos.jar`. Quando tu mandar o `ENTER` o programa deve começar a rodar.
1. Agora é só acompanhar e esperar a mensagem avisando que acabou de rodar.

E aí, funcionou tudo direitinho? Espero que sim! 

Ah! Você também tem a opção de usar nomes diferentes pros teus arquivos de entrada e saída! Por exemplo, se você rodar `java -jar consulta-enderecos.jar entrada1.csv saida25.csv`, o programa vai procurar na mesma pasta um arquivo chamado `entrada1.csv` e, caso o encontre, vai gerar um arquivo de saída chamado `saida25.csv`. Você pode colocar qualquer nome que quiser, basta que o arquivo de entrada exista na mesma pasta onde o programa está baixado.

Caso você tenha encontrado algum problema, me faz um favor? Me manda um e-mail dizendo o que você tentou fazer e anexa o arquivo de endereços que tu tá tentando usar, por favor? Assim posso te ajudar mais rápido.
  
É isso! Espero que funcione bem! Qualquer dúvida, ou se precisar melhorar alguma coisa, estamos aí!
