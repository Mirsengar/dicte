package contagiouscode.mirsengar.dicte.domian.repository

import contagiouscode.mirsengar.dicte.data.local.entity.BookmarkEntity
import contagiouscode.mirsengar.dicte.data.local.entity.HistoryEntity
import kotlinx.coroutines.flow.Flow

interface WordBaseRepository {
     
     suspend fun insertBookmark(bookmarkEntity : BookmarkEntity)
     
     suspend fun insertHistory(historyEntity : HistoryEntity)
     
     suspend fun getAllBookmark() : Flow<List<BookmarkEntity>>
     
     suspend fun getAllHistory() : Flow<List<HistoryEntity>>
     
     suspend fun deleteBookmark(bookmarkEntity : BookmarkEntity)
     
     suspend fun deleteHistory(historyEntity : HistoryEntity)
     
}