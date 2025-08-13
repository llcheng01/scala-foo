package example

class Cat(val name: String, val color: String, val food: String)
    extends Greeting {
  def greet() = greeting + " " + name
}
