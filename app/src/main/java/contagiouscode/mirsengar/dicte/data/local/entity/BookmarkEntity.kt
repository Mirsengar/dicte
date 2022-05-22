package contagiouscode.mirsengar.dicte.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import contagiouscode.mirsengar.dicte.domian.model.WordModel

@Entity(tableName = "bookmarkTable")
data class BookmarkEntity(
          val meanings : List<Meaning>? ,
          val word : String ,
          @PrimaryKey
          val wordsetId : String ,
) {
     fun toWordModel() : WordModel {
          return WordModel(meanings , word , wordsetId)
     }
}