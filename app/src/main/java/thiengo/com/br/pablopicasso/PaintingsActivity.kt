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

        setAppBarHeight()
        initRecyclerView()
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_paintings, menu)
        return true
    }

    private fun initRecyclerView(){

        rv_paintings.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        rv_paintings.layoutManager = layoutManager

        val divider = DividerItemDecoration(this, layoutManager.orientation)
        rv_paintings.addItemDecoration(divider)

        rv_paintings.adapter = PaintingsAdapter(this, Database.getPaintings() )
    }
}
