class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEndOfWord: Boolean = false
}

class Trie {
    private val root = TrieNode()
    
    fun insert(word: String) {
        var currentNode = root
        for (char in word) {
            currentNode = currentNode.children.computeIfAbsent(char) { TrieNode() }
        }
        currentNode.isEndOfWord = true
    }
    
    fun search(word: String): Boolean {
        var currentNode = root
        for (char in word) {
            currentNode = currentNode.children[char] ?: return false
        }
        return currentNode.isEndOfWord
    }
    
    fun startsWith(prefix: String): Boolean {
        var currentNode = root
        for (char in prefix) {
            currentNode = currentNode.children[char] ?: return false
        }
        return true
    }
}

fun main() {
    val trie = Trie()
    trie.insert("apple")
    println(trie.search("apple"))  // returns true
    println(trie.search("app"))    // returns false
    println(trie.startsWith("app")) // returns true
    trie.insert("app")
    println(trie.search("app"))    // returns true
}
