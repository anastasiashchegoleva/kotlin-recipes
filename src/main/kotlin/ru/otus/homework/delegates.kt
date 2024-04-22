package ru.otus.homework

fun main() {
    val catVet = CatVetImpl("Ivan")
    val dogVet = DogVetImpl("Petr")
    val vetClinic = VetClinic(catVet, dogVet)
    vetClinic.treat(Cat())
    vetClinic.treat(Dog())
}

class VetClinic(private val catVet: CatVet, private val dogVet: DogVet): CatVet, DogVet {
    override fun treat(cat: Cat) {
        catVet.treat(cat)
    }

    override fun treat(dog: Dog) {
        dogVet.treat(dog)
    }
}

interface CatVet {
    fun treat(cat: Cat)
}

class CatVetImpl(private val name: String) : CatVet {
    override fun treat(cat: Cat) {
        println("I'm doctor $name and I'm treating a cat")
        cat.meow()
    }
}

class Cat {
    fun meow() {
        println("Meow")
    }
}

interface DogVet {
    fun treat(dog: Dog)
}

class DogVetImpl(private val name: String) : DogVet {
    override fun treat(dog: Dog) {
        println("I'm doctor $name and I'm treating a dog")
        dog.bark()
    }
}

class Dog {
    fun bark() {
        println("Bark")
    }
}