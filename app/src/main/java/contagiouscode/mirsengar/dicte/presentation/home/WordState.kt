package contagiouscode.mirsengar.dicte.presentation.home

import contagiouscode.mirsengar.dicte.domian.model.WordModel

data class WordState(
          val wordModel : WordModel? = null ,
          var isLoading : Boolean = false ,
          var isContained : Boolean = false ,
)