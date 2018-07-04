package thiengo.com.br.pablopicasso

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_paintings.*
import thiengo.com.br.pablopicasso.domain.Painting
import android.view.ViewGroup
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.AppBarLayout
import android.util.Log
import com.squareup.picasso.Picasso
import thiengo.com.br.pablopicasso.data.Database


class PaintingsActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paintings)
        setSupportActionBar(toolbar)

        setAppBarHeight()

        initRecyclerView()
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
