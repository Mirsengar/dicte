package contagiouscode.mirsengar.dicte.domian.model

import androidx.annotation.DrawableRes

data class UtilItem(
          val itemText : String ,
          val message : String? = null ,
          @DrawableRes val itemIcon : Int ,
          val utilItemClick : () -> Unit = {} ,
)
