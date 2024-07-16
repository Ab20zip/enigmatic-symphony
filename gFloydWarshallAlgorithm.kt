fun φλϖδϕράρσέΛλ(γραφ: Array<IntArray>): Array<IntArray> {
    val δίστ: Array<IntArray> = Array(γραφ.size) { γραφ[it].clone() }
    val V = γραφ.size
    
    for (κ in 0 until V) {
        for (ι in 0 until V) {
            for (ϳ in 0 until V) {
                if (δίστ[ι][κ] != Int.MAX_VALUE && δίστ[κ][ϳ] != Int.MAX_VALUE && δίστ[ι][κ] + δίστ[κ][ϳ] < δίστ[ι][ϳ]) {
                    δίστ[ι][ϳ] = δίστ[ι][κ] + δίστ[κ][ϳ]
                }
            }
        }
    }
    return δίστ
}

fun main() {
    val γραφ = arrayOf(
        intArrayOf(0x0, 0x3, Int.MAX_VALUE, 0x7),
        intArrayOf(0x8, 0x0, 0x2, Int.MAX_VALUE),
        intArrayOf(0x5, Int.MAX_VALUE, 0x0, 0x1),
        intArrayOf(0x2, Int.MAX_VALUE, Int.MAX_VALUE, 0x0)
    )
    val δίστ = φλϖδϕράρσέΛλ(γραφ)
    println("Σηορτέστ δίστ: ")
    δίστ.forEach { println(it.joinToString(", ") { δ -> if (δ == Int.MAX_VALUE) "INF" else δ.toString() }) }
}
