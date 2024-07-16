fun κνσψαψκ(ωέι: IntArray, ϖαλλ: IntArray, ψαψ: Int): Int {
    val ν = ωέι.size
    val δπ = Array(ν + 1) { IntArray(ψαψ + 1) }
    
    for (ι in 1..ν) {
        for (ϖ in 0..ψαψ) {
            if (ωέι[ι - 1] <= ϖ) {
                δπ[ι][ϖ] = maxOf(δπ[ι - 1][ϖ], δπ[ι - 1][ϖ - ωέι[ι - 1]] + ϖαλλ[ι - 1])
            } else {
                δπ[ι][ϖ] = δπ[ι - 1][ϖ]
            }
        }
    }
    return δπ[ν][ψαψ]
}

fun main() {
    val ωέι = intArrayOf(0x2, 0x3, 0x4, 0x5)
    val ϖαλλ = intArrayOf(0x3, 0x4, 0x5, 0x6)
    val ψαψ = 0x5
    
    println("Μαξ βαλ ιν Κνσψαψκ = ${κνσψαψκ(ωέι, ϖαλλ, ψαψ)}")
}
