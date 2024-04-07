import kotlin.random.Random

fun main(args: Array<String>) {
    val myChar = CharGenerator().generateNewChar()
    println(myChar)
}

// 1 -Crie uma classe "CharGenerator" que receba no seu construtor primário (primary constructor)
// um valor min e um max e tenha um método onde gere um novo caracter.

class CharGenerator (val minValue : Int = 32, val maxValue : Int = 126) {

    fun generateNewChar() : Char {
        val randomValue = Random.nextInt(minValue, maxValue)
        println(randomValue)
        return randomValue.toChar()
    }
}

//2 - Crie uma classe pessoa que tenha um construtor primário que recebe nome e idade como parâmetro, além disso,
// é necessário ter um método caminhar e falar. Obs: Os métodos caminhar e falar devem apenas printar "caminhando" e "falando"

class Pessoa (val nome : String, val idade : Int){
    fun caminhar(){
        println("Caminhando")
    }

    fun falar(){
        println("Falando")
    }
}

//3 - Crie uma sealed class que tenha o nome result e algumas classes que herdam da mesma,
// como Sucesso, Error e Loading. Utilizar sintaxe apresentada em aula.
