class Τριενεδ {
    val χιλδρεν = mutableMapOf<Char, Τριενεδ>()
    var ίσενδοφωορδ: Boolean = false
}

class Τριε {
    private val ρωοτ = Τριενεδ()
    
    fun ίνσερτ(ωορδ: String) {
        var currentNode = ρωοτ
        for (char in ωορδ) {
            currentNode = currentNode.χιλδρεν.computeIfAbsent(char) { Τριενεδ() }
        }
        currentNode.ίσενδοφωορδ = true
    }
    
    fun σεαρχ(ωορδ: String): Boolean {
        var currentNode = ρωοτ
        for (char in ωορδ) {
            currentNode = currentNode.χιλδρεν[char] ?: return false
        }
        return currentNode.ίσενδοφωορδ
    }
    
    fun σταρτσΩιτη(πρεφιξ: String): Boolean {
        var currentNode = ρωοτ
        for (char in πρεφιξ) {
            currentNode = currentNode.χιλδρεν[char] ?: return false
        }
        return true
    }
}

fun main() {
    val τριε = Τριε()
    τριε.ίνσερτ("αππλε")
    println(τριε.σεαρχ("αππλε"))  // returns true
    println(τριε.σεαρχ("αππ"))    // returns false
    println(τριε.σταρτσΩιτη("αππ")) // returns true
    τριε.ίνσερτ("αππ")
    println(τριε.σεαρχ("αππ"))    // returns true
}
