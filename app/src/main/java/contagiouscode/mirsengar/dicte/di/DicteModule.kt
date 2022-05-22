package contagiouscode.mirsengar.dicte.di

import android.content.Context
import androidx.room.Room
import contagiouscode.mirsengar.dicte.data.DictionaryDatabase
import contagiouscode.mirsengar.dicte.data.WordModelDatabase
import contagiouscode.mirsengar.dicte.data.local.DictionaryDao
import contagiouscode.mirsengar.dicte.data.local.WordModelDao
import contagiouscode.mirsengar.dicte.data.repository.DictionaryRepository
import contagiouscode.mirsengar.dicte.data.repository.WordRepository
import contagiouscode.mirsengar.dicte.domian.repository.DictionaryBaseRepository
import contagiouscode.mirsengar.dicte.domian.repository.WordBaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DicteModule {
     
     @Provides
     @Singleton
     fun provideWordRepository(
               wordModelDao : WordModelDao ,
     ) : WordBaseRepository {
          return WordRepository(wordModelDao)
     }
     
     @Provides
     @Singleton
     fun provideDictRepository(
               dictionaryDao : DictionaryDao ,
     ) : DictionaryBaseRepository {
          return DictionaryRepository(dictionaryDao)
     }
     
     @Provides
     @Singleton
     fun provideWordModelDao(wordModelDatabase : WordModelDatabase) : WordModelDao {
          return wordModelDatabase.wordModelDao
     }
     
     @Provides
     @Singleton
     fun provideDictionaryDao(dictionaryDatabase : DictionaryDatabase) : DictionaryDao {
          return dictionaryDatabase.dictionaryDao
     }
     
     @Provides
     @Singleton
     fun provideDictionaryDatabase(@ApplicationContext appContext : Context) : DictionaryDatabase {
          return Room.databaseBuilder(appContext , DictionaryDatabase::class.java, "dictionaryDb")
                    .createFromAsset("wordset/wordDB")
                    .build()
     }
     
     @Provides
     @Singleton
     fun provideWordModelDatabase(@ApplicationContext appContext : Context) : WordModelDatabase {
          return Room.databaseBuilder(appContext , WordModelDatabase::class.java , "wordModelDb")
                    .build()
     }
}