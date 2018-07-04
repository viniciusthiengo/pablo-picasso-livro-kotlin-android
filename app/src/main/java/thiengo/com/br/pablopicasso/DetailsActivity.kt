package thiengo.com.br.pablopicasso

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import thiengo.com.br.pablopicasso.domain.Painting
import android.util.Log
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*
import thiengo.com.br.pablopicasso.extension.setStar
import java.lang.Exception


class DetailsActivity : MainActivity() {

    lateinit var painting: Painting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setAppBarHeight()

        painting = intent.getParcelableExtra(Painting.KEY)

        /*
         * Debug para certificar que não está ocorrendo uma
         * nova requisção aos servidores remotos que contém
         * as imagens.
         * */
        /*Picasso
            .get()
            .setIndicatorsEnabled(true)*/

        // Colocando a pintura.
        Picasso
            .get()
            .load(painting.imageUrl)
            .centerInside()
            .fit()
            .into(iv_painting)

        // Colocando os dados em texto.
        iv_painting.contentDescription = painting.name
        tv_year.text = painting.year.toString()
        tv_price.text = painting.getPriceBRFormat()
        tv_details.text = painting.details

        // Colocando as estrelas.
        iv_star_01.setStar(painting.rating, 1)
        iv_star_02.setStar(painting.rating, 2)
        iv_star_03.setStar(painting.rating, 3)
        iv_star_04.setStar(painting.rating, 4)
        iv_star_05.setStar(painting.rating, 5)
    }

    /*
     * Para que a atualização do título da Toolbar seja
     * efetivo.
     */
    override fun onResume() {
        super.onResume()
        toolbar.title = painting.name
    }

    /*
     * Seguindo as recomendações da documentação e garantindo
     * de nenhuma requisição permanecerá, retendo a atividade
     * em memória para não ser recolhida pelo Garbage Collector.
     * */
    override fun onPause() {
        super.onPause()
        if( isFinishing ){
            Picasso
                .get()
                .cancelTag(iv_painting)
        }
    }
}
