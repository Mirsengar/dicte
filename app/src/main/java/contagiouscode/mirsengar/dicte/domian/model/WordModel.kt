package contagiouscode.mirsengar.dicte.domian.model

import contagiouscode.mirsengar.dicte.data.local.entity.BookmarkEntity
import contagiouscode.mirsengar.dicte.data.local.entity.HistoryEntity
import contagiouscode.mirsengar.dicte.data.local.entity.Meaning

data class WordModel(
          val meanings : List<Meaning>? ,
          val word : String ,
          val wordSetId : String ,
) {
     fun toBookmarkEntity() : BookmarkEntity {
          return BookmarkEntity(meanings , word , wordSetId)
     }
     
     fun toHistoryEntity() : HistoryEntity {
          return HistoryEntity(meanings , word , wordSetId)
     }
}