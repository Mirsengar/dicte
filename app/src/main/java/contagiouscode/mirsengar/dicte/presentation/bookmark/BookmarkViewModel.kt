package contagiouscode.mirsengar.dicte.presentation.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import contagiouscode.mirsengar.dicte.data.repository.WordRepository
import contagiouscode.mirsengar.dicte.domian.model.WordModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(private val wordRepo : WordRepository) : ViewModel() {
     var bookmarks = MutableStateFlow(listOf<WordModel>())
          private set
     
     fun deleteBookmark(wordModel : WordModel) {
          viewModelScope.launch(Dispatchers.IO) {
               wordRepo.deleteBookmark(wordModel.toBookmarkEntity())
          }
     }
     
     init {
          viewModelScope.launch(Dispatchers.IO) {
               wordRepo.getAllBookmark().collect { result ->
                    bookmarks.value = result.map { it.toWordModel() }
               }
          }
     }
}