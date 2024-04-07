fun main(args: Array<String>) {
    val list : List<Int> = listOf(12, 23, 10, 11, 2, 3, 4, 5, 199, 250, 48, 1, 2, 3)
    val listString : List<String> = listOf("Brasil", "Paris", "China", "Canadá", "Japão")
    val str : String = "Uma frase legal aqui"
    val str2 : String = "Uma calça pra uma jovem custa mais de 300 reais"

    println("${list}\n${listString}\n${str}\n${str2}\n")

    println("A media é: ${media(list)}")
    println("Os números pares são: ${numerosPares(list)}")
    println("Lista sem valores duplicados: ${removerDuplicados(list)}")
    println("O último valor impar é: ${ultimoImpar(list)}")

    println("Todos os elementos em maiúsculo ${listString.toUpper()}")
    println("Mudando a caixa da String: ${str.upper()}")
    println("Concatendo RS aos numeros: ${str2.concatenarCifrao()}")

}

// 1 - Escreva uma função que recebe uma lista de números e retorna a média aritmética
fun media(numeros : List<Int>) : Int{
    var soma : Int = 0
    numeros.forEach { soma += it }
    return soma / numeros.size
}

//2 - Escreva uma função que recebe uma lista de números e retorna apenas os números pares
fun numerosPares(numeros: List<Int>) : List<Int> {
    return numeros.filter { it % 2 == 0 }
}

//3 - Escreva uma função que remove números inteiros duplicados
fun removerDuplicados(numeros: List<Int>) : MutableSet<Int>{
    val elementosVistos = mutableSetOf<Int>()
    for(el in numeros){
        elementosVistos.add(el)
    }
    return elementosVistos
}

//4 - Escreva uma função que encontra o último elemento ímpar em uma lista de inteiros
fun ultimoImpar(numeros : List<Int>) : Int{
    var impar : Int = 0
    for(x in numeros.size - 1  downTo 0) {
        if (numeros[x] % 2 != 0) {
            impar = numeros[x]
            break
        }
    }
    return impar
}

//5 - Escreva uma função que recebe uma lista de strings e retorna uma nova lista com todas as strings em maiúsculas
fun List<String>.toUpper() : List<String>{
    return this.map { it.uppercase() }
}

//6 - Escreva uma função de extensão onde disponibiliza para todas as Strings uma função que deixa todas as letras maiúsculas.
fun String.upper() : String{
    return this.uppercase()
}

//7 - Escreva uma função de extensão onde disponibiliza para todas as Strings uma função que concatena o R$ aos números.
fun String.concatenarCifrao() : String{
    val regex = Regex("\\b\\d+\\b")
    val txtConcatenado = this.replace(regex) {"R$${it.value}"}
    return txtConcatenado
}