package thiengo.com.br.pablopicasso.data

import thiengo.com.br.pablopicasso.domain.Painting

class Database {
    companion object {
        fun getPaintings() =
            listOf(
                Painting(
                    "Painter and Model",
                    1928,
                    "https://www.pablopicasso.org/images/paintings/painter-and-model.jpg",
                    15.6,
                    4.0,
                    "Um artista vivo que Picasso sempre teve em vista era Matisse. Dado o tema de Painter e MOdel isso não é surpresa, e ele pode ter tido um Matisses em mente, o monumental Goldfish e Palette 1915. Isso começou como uma imagem do artista com sua paleta contemplando uma natureza morta em uma mesa, e a seção vertical central da composição de Picasso (incorporando o espelho, a janela, a natureza morta, a tela, a paleta e metade do corpo do pintor) tem tantos detalhes em comum com a pintura de Matisse que o termo \"paráfrase\" parece apropriado. Picasso conhecia bem Goldfish e Palette porque fora com Leonce Rosenberg de 1915 a 1923, quando, graças ao fervoroso lobby de ninguém menos do que Andre Breton, foi comprado por Jacques Doucet. Ele também sabia que, com ou sem razão, Matisse estava convencido de que havia influenciado seu próprio Arlequim de 1915."
                ),
                Painting(
                    "Les Demoiselles d'Avignon",
                    1907,
                    "http://www.pablopicasso.org/images/paintings/avignon.jpg",
                    29.1,
                    5.0,
                    "Esta pintura, Les Demoiselles d'Avignon, foi pintada em 1907 e é o exemplo mais famoso da pintura do cubismo. Nesta pintura, Picasso abandonou todas as formas e representações conhecidas da arte tradicional. Ele usou a distorção do corpo feminino e das formas geométricas de uma forma inovadora, o que desafia a expectativa de que as pinturas oferecerão representações idealizadas da beleza feminina. Também mostra a influência da arte africana em Picasso. Esta pintura é um grande trabalho e levou nove meses para ser concluída. Ele demonstra o verdadeiro gênio e novidade da paixão de Picasso. Ele criou centenas de esboços e estudos para se preparar para o trabalho final. Alguns críticos argumentam que a pintura foi uma reação a Le bonheur de vivre e Blue Nude, de Henri Matisse."
                ),
                Painting(
                    "Jacqueline Kneeling",
                    1954,
                    "http://www.pablopicasso.org/images/paintings/jacqueline-kneeling.jpg",
                    7.7,
                    3.5,
                    "O ano de 1954 foi deprimente para Picasso. Vários de seus amigos de longa data, incluindo os escritores Maurice Raynal e Paul Eluord, e o pintor Henri Matisse morrera recentemente. Seu relacionamento com Françoise havia desmoronado. A partida de Françoise e dos filhos deixou Picasso em paz, mas uma nova mulher, Jacqueline Roque, logo apareceu em cena. Agora em seus setenta anos, Picasso começou o que seria seu último grande relacionamento."
                )
            )
    }
}