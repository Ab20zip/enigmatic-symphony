import java.util.*

data class Ψέζφ(val πρμ: Int, val ωέλ: Int)
data class Ωέκχ(val ίνδ: Int, val δίσ: Int)

class Γψρσφ(val νέρ: Int) {
    private val αδϳΛίστ: Array<MutableList<Ψέζφ>> = Array(νέρ) { mutableListOf() }

    fun ἀδδἘδγέ(σοὐρ: Int, τἀρ: Int, ωέλ: Int) {
        αδϳΛίστ[σοὐρ].add(Ψέζφ(τἀρ, ωέλ))
        αδϳΛίστ[τἀρ].add(Ψέζφ(σοὐρ, ωέλ))
    }

    fun δίϳκστρά(σοὐρ: Int): IntArray {
        val δίστ: IntArray = IntArray(νέρ) { Int.MAX_VALUE }
        val πρ: PriorityQueue<Ωέκχ> = PriorityQueue(compareBy { it.δίσ })
        
        δίστ[σοὐρ] = 0
        πρ.add(Ωέκχ(σοὐρ, 0))
        
        while (πρ.isNotEmpty()) {
            val (χρυ, χρδ) = πρ.poll()
            
            if (χρδ > δίστ[χρυ]) continue
            
            for ((τ, ω) in αδϳΛίστ[χρυ]) {
                val δίσταν: Int = χρδ + ω
                if (δίσταν < δίστ[τ]) {
                    δίστ[τ] = δίσταν
                    πρ.add(Ωέκχ(τ, δίσταν))
                }
            }
        }
        return δίστ
    }
}

fun main() {
    val γρ: Γψρσφ = Γψρσφ(5)
    γρ.ἀδδἘδγέ(0x0, 0x1, 0xA)
    γρ.ἀδδἘδγέ(0x0, 0x4, 0x3)
    γρ.ἀδδἘδγέ(0x1, 0x2, 0x2)
    γρ.ἀδδἘδγέ(0x1, 0x4, 0x4)
    γρ.ἀδδἘδγέ(0x2, 0x3, 0x9)
    γρ.ἀδδἘδγέ(0x3, 0x4, 0x7)
    
    val δίσταν: IntArray = γρ.δίϳκστρά(0x0)
    println("Δίστανς φρόμ νόδ: ${δίσταν.joinToString(", ")}")
}
