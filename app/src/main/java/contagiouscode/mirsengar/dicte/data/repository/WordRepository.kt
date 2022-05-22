package contagiouscode.mirsengar.dicte.data.repository

import contagiouscode.mirsengar.dicte.data.local.WordModelDao
import contagiouscode.mirsengar.dicte.data.local.entity.BookmarkEntity
import contagiouscode.mirsengar.dicte.data.local.entity.HistoryEntity
import contagiouscode.mirsengar.dicte.domian.repository.WordBaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WordRepository @Inject constructor(
          private val wordModelDao : WordModelDao ,
) : WordBaseRepository {
     
     override suspend fun insertBookmark(bookmarkEntity : BookmarkEntity) {
          wordModelDao.insertBookmark(bookmarkEntity)
     }
     
     override suspend fun insertHistory(historyEntity : HistoryEntity) {
          wordModelDao.insertHistory(historyEntity)
     }
     
     override suspend fun getAllBookmark() : Flow<List<BookmarkEntity>> =
               wordModelDao.getAllBookmark()
     
     override suspend fun getAllHistory() : Flow<List<HistoryEntity>> =
               wordModelDao.getAllHistory()
     
     override suspend fun deleteBookmark(bookmarkEntity : BookmarkEntity) {
          wordModelDao.deleteBookmark(bookmarkEntity)
     }
     
     override suspend fun deleteHistory(historyEntity : HistoryEntity) {
          wordModelDao.deleteHistory(historyEntity)
     }
}