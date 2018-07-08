package thiengo.com.br.pablopicasso

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_paintings.*
import kotlinx.android.synthetic.main.activity_top_bar.*
import thiengo.com.br.pablopicasso.data.Database


class PaintingsActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paintings)
        setSupportActionBar(toolbar)

        // Iniciando a barra de topo personalizada.
        setAppBarHeight()

        initRecyclerView()
    }

    /*
     * Código de configuração inicial do RecyclerView que será
     * utilizado em projeto, incluindo a linha divisora de itens,
     * criada via DividerItemDecoration.
     * */
    private fun initRecyclerView(){

        rv_paintings.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        rv_paintings.layoutManager = layoutManager

        val divider = DividerItemDecoration(this, layoutManager.orientation)
        rv_paintings.addItemDecoration(divider)

        rv_paintings.adapter = PaintingsAdapter(this, Database.getPaintings() )
    }

    /*
     * Seguindo recomendações encontradas nos códigos de exemplo da
     * documentação oficial da Picasso API. Para que invocações que
     * ocorrem em classes adaptadoras sejam removidas quando não
     * houver mais a necessidade de carregamento de imagens, coloque
     * no onDestroy() da atividade / fragmento o código de cancelamento
     * de requisição.
     * */
    override fun onDestroy() {
        super.onDestroy()
        Picasso.get().cancelTag(this)
    }

    /*
     * Está aqui neste exemplo somente para que seja possível inflar o
     * menu que contém o ícone de busca, mas este ícone é apenas um
     * atributo de layout, não terá funcionalidade.
     * */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_paintings, menu)
        return true
    }
}
