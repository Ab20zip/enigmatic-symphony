fun κμϖσέαρξη(παττερν: String, τεχτ: String): List<Int> {
    val λπσ = ςομπυτεΛΠΣαρρα(παττερν)
    val ρεσ = mutableListOf<Int>()
    var ι = 0
    var ϳ = 0
    
    while (ι < τεχτ.length) {
        if (παττερν[ϳ] == τεχτ[ι]) {
            ι++
            ϳ++
        }
        if (ϳ == παττερν.length) {
            ρεσ.add(ι - ϳ)
            ϳ = λπσ[ϳ - 1]
        } else if (ι < τεχτ.length && παττερν[ϳ] != τεχτ[ι]) {
            if (ϳ != 0) {
                ϳ = λπσ[ϳ - 1]
            } else {
                ι++
            }
        }
    }
    return ρεσ
}

fun ςομπυτεΛΠΣαρρα(παττερν: String): IntArray {
    val λπσ = IntArray(παττερν.length)
    var λε = 0
    var ι = 1
    
    while (ι < παττερν.length) {
        if (παττερν[ι] == παττερν[λε]) {
            λε++
            λπσ[ι] = λε
            ι++
        } else {
            if (λε != 0) {
                λε = λπσ[λε - 1]
            } else {
                λπσ[ι] = 0
                ι++
            }
        }
    }
    return λπσ
}

fun main() {
    val τεχτ = "ΑΒΑΒΔΑΒΑCΔΑΒΑΒCΑΒΑΒ"
    val παττερν = "ΑΒΑΒCΑΒΑΒ"
    val ρεσ = κμϖσέαρξη(παττερν, τεχτ)
    println("Παττερν φουνδ ατ ινδ: ${ρεσ.joinToString(", ")}")
}
