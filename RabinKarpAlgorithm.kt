fun rabinKarp(text: String, pattern: String): List<Int> {
    val result = mutableListOf<Int>()
    val d = 256
    val q = 101
    val m = pattern.length
    val n = text.length
    var p = 0
    var t = 0
    var h = 1
    
    for (i in 0 until m - 1) {
        h = (h * d) % q
    }
    
    for (i in 0 until m) {
        p = (d * p + pattern[i].toInt()) % q
        t = (d * t + text[i].toInt()) % q
    }
    
    for (i in 0..n - m) {
        if (p == t) {
            var j = 0
            while (j < m && pattern[j] == text[i + j]) {
                j++
            }
            if (j == m) {
                result.add(i)
            }
        }
        if (i < n - m) {
            t = (d * (t - text[i].toInt() * h) + text[i + m].toInt()) % q
            if (t < 0) t += q
        }
    }
    return result
}

fun main() {
    val text = "ABCCDDAEFG"
    val pattern = "CDD"
    val result = rabinKarp(text, pattern)
    println("Pattern found at indices: ${result.joinToString(", ")}")
}
