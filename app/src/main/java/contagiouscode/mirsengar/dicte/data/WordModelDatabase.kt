package contagiouscode.mirsengar.dicte.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import contagiouscode.mirsengar.dicte.data.local.WordModelDao
import contagiouscode.mirsengar.dicte.data.local.converters.LabelConverter
import contagiouscode.mirsengar.dicte.data.local.converters.MeaningConverter
import contagiouscode.mirsengar.dicte.data.local.converters.SynonymConverter
import contagiouscode.mirsengar.dicte.data.local.entity.BookmarkEntity
import contagiouscode.mirsengar.dicte.data.local.entity.HistoryEntity

@TypeConverters(value = [MeaningConverter::class , SynonymConverter::class , LabelConverter::class])
@Database(entities = [BookmarkEntity::class , HistoryEntity::class] , exportSchema = true , version = 1)
abstract class WordModelDatabase : RoomDatabase() {
     abstract val wordModelDao : WordModelDao
}