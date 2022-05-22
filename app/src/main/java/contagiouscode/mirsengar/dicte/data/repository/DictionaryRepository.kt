package contagiouscode.mirsengar.dicte.data.repository

import androidx.sqlite.db.SimpleSQLiteQuery
import contagiouscode.mirsengar.dicte.domian.repository.DictionaryBaseRepository
import contagiouscode.mirsengar.dicte.data.local.DictionaryDao
import contagiouscode.mirsengar.dicte.data.local.entity.DictionaryEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DictionaryRepository @Inject constructor(
          private val dictionaryDao: DictionaryDao ,
) : DictionaryBaseRepository {
    override fun prefixMatch(word: String): Flow<List<DictionaryEntity>> = flow {
        val isValidLetter = Character.isLetter(word.first().lowercase().toCharArray()[0])
        if (isValidLetter) {
            val query = """
                SELECT * FROM ${word.first()}_table WHERE word LIKE ? ORDER BY word ASC LIMIT 20
            """
            val queryObj = SimpleSQLiteQuery(query, arrayOf("${word}%"))
            emit(dictionaryDao.prefixMatch(queryObj))
        }

    }

    override fun search(word: String): Flow<List<DictionaryEntity>> = flow {
        val isValidLetter = Character.isLetter(word.first().lowercase().toCharArray()[0])
        if (isValidLetter) {
            val query = """
                SELECT * FROM ${word.first()}_table WHERE word = ?
            """
            val queryObj = SimpleSQLiteQuery(query, arrayOf(word))
            emit(listOf(dictionaryDao.search(queryObj)))
        }
    }
}