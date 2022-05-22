package contagiouscode.mirsengar.dicte.util

import contagiouscode.mirsengar.dicte.domian.model.WordModel

class TrieNode<Key>(var key : Key? , var parent : TrieNode<Key>?) {
     val children : HashMap<Key , TrieNode<Key>> = HashMap()
     var isValidWord = false
     var wordModel : WordModel? = null
}