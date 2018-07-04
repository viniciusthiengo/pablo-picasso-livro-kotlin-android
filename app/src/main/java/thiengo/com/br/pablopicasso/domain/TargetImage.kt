package thiengo.com.br.pablopicasso.domain

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import thiengo.com.br.pablopicasso.R
import java.lang.Exception

class TargetImage(
    val imageView: ImageView,
    val url: String,
    val isInList: Boolean = true ): Target {

    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}

    /*
     * Em caso de falha de carregamento de imagem, tentamos alterar
     * o protocolo dela, saindo de um sem SSL, HTTP, e indo para um
     * com SSL, HTTPS. Ou vice-versa. Essa é a única tentativa extra
     * que nos resta, se mesmo assim a imagem não for carregada,
     * apresentamos a imagem de erro. Fico tranquilo, o objeto Target
     * somente será utilizado se invocado novamente, ou seja, não
     * temos o risco aqui de entrarmos em loop inifinito, pois a nova
     * invocação de Picasso.get() não há referência a algum Target.
     * */
    override fun onBitmapFailed(
        e: Exception?,
        errorDrawable: Drawable? ) {

        val newUrl = when{
            url.contains("https:") -> url.replace("https:", "http:")
            else -> url.replace("http:", "https:")
        }

        callPicassoLoad( newUrl )
    }

    /*
     * Se a imagem tiver sido carregada sem problemas, invocamos o
     * Picasso agora com fit() e centerInside(), isso para ajustar a
     * imagem no ImageView, pois com o Target não é possível trabalhar
     * com esses métodos (o fit() não). Não risco de loop inifinito
     * aqui, pois não estamos utilizando novamente uma instância de
     * TargetImage. A imagem já estará em cache, também não haverá
     * um novo carregamento remoto.
     * */
    override fun onBitmapLoaded(
        bitmap: Bitmap?,
        from: Picasso.LoadedFrom?) {

        // A imagem já está em cache. Não haverá um novo carregamento remoto.
        callPicassoLoad( url )
    }

    /*
     * Para realizar a invocação de imagem correta, quando em lista ou
     * quando em atividade de detalhes.
     * */
    private fun callPicassoLoad( urlImage: String ){
        if( isInList ){
            Picasso
                .get()
                .load( urlImage )
                .error(R.drawable.error_in_list)
                .centerCrop()
                .fit()
                .into(imageView)
        }
        else{
            Picasso
                .get()
                .load( urlImage )
                .error(R.drawable.error_in_details)
                .centerInside()
                .fit()
                .into(imageView)
        }
    }
}