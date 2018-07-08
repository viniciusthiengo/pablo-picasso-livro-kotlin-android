package thiengo.com.br.pablopicasso

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import thiengo.com.br.pablopicasso.domain.Painting
import thiengo.com.br.pablopicasso.domain.TargetImage
import thiengo.com.br.pablopicasso.extension.setStar

class PaintingsAdapter(
        private val context: Context,
        private val paintings: List<Painting> ) :
        RecyclerView.Adapter<PaintingsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int ) : PaintingsAdapter.ViewHolder {

        val v = LayoutInflater
                .from(context)
                .inflate( R.layout.painting, parent, false )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int ) {

        holder.setData( paintings[position] )
    }

    override fun getItemCount(): Int {
        return paintings.size
    }

    inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView),
            View.OnClickListener {

        val ivPainting: ImageView
        val tvName: TextView
        val tvYear: TextView
        val tvPrice: TextView
        val ivStar_01: ImageView
        val ivStar_02: ImageView
        val ivStar_03: ImageView
        val ivStar_04: ImageView
        val ivStar_05: ImageView

        init {
            itemView.setOnClickListener(this)

            ivPainting = itemView.findViewById(R.id.iv_painting)
            tvName = itemView.findViewById(R.id.tv_name)
            tvYear = itemView.findViewById(R.id.tv_year)
            tvPrice = itemView.findViewById(R.id.tv_price)

            ivStar_01 = itemView.findViewById(R.id.iv_star_01)
            ivStar_02 = itemView.findViewById(R.id.iv_star_02)
            ivStar_03 = itemView.findViewById(R.id.iv_star_03)
            ivStar_04 = itemView.findViewById(R.id.iv_star_04)
            ivStar_05 = itemView.findViewById(R.id.iv_star_05)
        }

        fun setData( painting: Painting ) {
            /*
             * Para posteriormente criarmos uma referência forte a instância
             * de Target, colocamos ela em uma variável.
             * */
            val target = TargetImage(
                ivPainting,
                painting.imageUrl
            )

            /*
             * Hackcode para que a instância de Target não seja perdida. Aqui
             * estamos criando uma referência forte a ela.
             * */
            ivPainting.tag = target

            // Colocando a pintura.
            Picasso
                .get()
                .load(painting.imageUrl)
                .into(target)

            // Colocando os dados em texto.
            ivPainting.contentDescription = painting.name
            tvName.text = painting.name
            tvYear.text = painting.year.toString()
            tvPrice.text = painting.getPriceBRFormat(
                context.getString(R.string.label_money_sign),
                context.getString(R.string.label_millions)
            )

            // Colocando as estrelas.
            ivStar_01.setStar(painting.rating, 1)
            ivStar_02.setStar(painting.rating, 2)
            ivStar_03.setStar(painting.rating, 3)
            ivStar_04.setStar(painting.rating, 4)
            ivStar_05.setStar(painting.rating, 5)
        }

        /*
         * Invocando a atividade de detalhes para o item,
         * pintura, selecionado.
         * */
        override fun onClick(view: View) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra( Painting.KEY, paintings[ adapterPosition ] )
            context.startActivity( intent )
        }
    }
}