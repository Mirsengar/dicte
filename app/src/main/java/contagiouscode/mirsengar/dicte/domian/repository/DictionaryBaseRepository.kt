package contagiouscode.mirsengar.dicte.domian.repository

import contagiouscode.mirsengar.dicte.data.local.entity.DictionaryEntity
import kotlinx.coroutines.flow.Flow

interface DictionaryBaseRepository {
     fun search(word : String) : Flow<List<DictionaryEntity>>
     
     fun prefixMatch(word : String) : Flow<List<DictionaryEntity>>
}