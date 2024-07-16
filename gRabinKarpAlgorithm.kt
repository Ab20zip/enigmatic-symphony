fun ράβικαρπ(τεχτ: String, παττερν: String): List<Int> {
    val ρεσ = mutableListOf<Int>()
    val δ = 256
    val ϙ = 101
    val μ = παττερν.length
    val ν = τεχτ.length
    var π = 0
    var τ = 0
    var η = 1
    
    for (ι in 0 until μ - 1) {
        η = (η * δ) % ϙ
    }
    
    for (ι in 0 until μ) {
        π = (δ * π + παττερν[ι].toInt()) % ϙ
        τ = (δ * τ + τεχτ[ι].toInt()) % ϙ
    }
    
    for (ι in 0..ν - μ) {
        if (π == τ) {
            var ϳ = 0
            while (ϳ < μ && παττερν[ϳ] == τεχτ[ι + ϳ]) {
                ϳ++
            }
            if (ϳ == μ) {
                ρεσ.add(ι)
            }
        }
        if (ι < ν - μ) {
            τ = (δ * (τ - τεχτ[ι].toInt() * η) + τεχτ[ι + μ].toInt()) % ϙ
            if (τ < 0) τ += ϙ
        }
    }
    return ρεσ
}

fun main() {
    val τεχτ = "ΑΒΧΧΔΔΑΕΦΓ"
    val παττερν = "ΧΔΔ"
    val ρεσ = ράβικαρπ(τεχτ, παττερν)
    println("Παττερν φουνδ ατ ινδ: ${ρεσ.joinToString(", ")}")
}
