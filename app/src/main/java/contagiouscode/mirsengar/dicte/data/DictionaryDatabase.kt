package contagiouscode.mirsengar.dicte.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import contagiouscode.mirsengar.dicte.data.local.DictionaryDao
import contagiouscode.mirsengar.dicte.data.local.converters.LabelConverter
import contagiouscode.mirsengar.dicte.data.local.converters.MeaningConverter
import contagiouscode.mirsengar.dicte.data.local.converters.SynonymConverter
import contagiouscode.mirsengar.dicte.data.local.entity.DictionaryEntity

@TypeConverters(value = [MeaningConverter::class , SynonymConverter::class , LabelConverter::class])
@Database(entities = [DictionaryEntity::class] , exportSchema = true , version = 2)
abstract class DictionaryDatabase : RoomDatabase() {
     abstract val dictionaryDao : DictionaryDao
}