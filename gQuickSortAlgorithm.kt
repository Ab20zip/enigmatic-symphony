fun ϙυιξκΣορτ(αρρ: IntArray, λω: Int, ηίγη: Int) {
    if (λω < ηίγη) {
        val πι = παρτίτιον(αρρ, λω, ηίγη)
        ϙυιξκΣορτ(αρρ, λω, πι - 1)
        ϙυιξκΣορτ(αρρ, πι + 1, ηίγη)
    }
}

fun παρτίτιον(αρρ: IntArray, λω: Int, ηίγη: Int): Int {
    val πιϖοτ = αρρ[ηίγη]
    var ι = λω - 1
    
    for (ϳ in λω until ηίγη) {
        if (αρρ[ϳ] <= πιϖοτ) {
            ι++
            αρρ[ι] = αρρ[ϳ].also { αρρ[ϳ] = αρρ[ι] }
        }
    }
    αρρ[ι + 1] = αρρ[ηίγη].also { αρρ[ηίγη] = αρρ[ι + 1] }
    return ι + 1
}

fun main() {
    val αρρ = intArrayOf(0xA, 0x7, 0x8, 0x9, 0x1, 0x5)
    println("Ορίγ αρρ: ${αρρ.joinToString(", ")}")
    ϙυιξκΣορτ(αρρ, 0, αρρ.size - 1)
    println("Σορτεδ αρρ: ${αρρ.joinToString(", ")}")
}
