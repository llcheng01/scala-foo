package fpinscala

object Ch6 {

  trait RNG {
    def nextInt: (Int, RNG)
  }

  case class SimpleRNG(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRNG = SimpleRNG(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRNG)
    }
  }

  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (i1, rng2) = rng.nextInt
    (Math.abs(i1), rng2)
  }

  def double(rng: RNG): (Double, RNG) = {
    val (i1, rng2) = nonNegativeInt(rng)
    (i1.toDouble / Int.MaxValue, rng2)
  }

  type Rand[+A] = RNG => (A, RNG)

  val int: Rand[Int] = _.nextInt

  def unit[A](a: A): Rand[A] =
    rng => (a, rng)

  def map[A, B](s: Rand[A])(f: A => B): Rand[B] =
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  // 6.5 Use map to re-implement double in a more elegant way.
  def double1: Rand[Double] = {
    map(nonNegativeInt)(i => i / (Int.MaxValue).toDouble)
  }

  // 6.6 implement map2
  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng =>
      {
        val (a, rng2) = ra(rng)
        val (b, rng3) = rb(rng2)
        (f(a, b), rng3)
      }
  }

  def both[A, B](ra: Rand[A], rb: Rand[B]): Rand[(A, B)] = {
    map2(ra, rb)((_, _))
  }

  // int and double are defined above
  val randIntDouble: Rand[(Int, Double)] =
    both(int, double)

  // 6.7
  // List[(A, RNG)]
  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = { rng =>
    fs match {
      case Nil => (Nil, rng)
      case x :: xs =>
        val (h, rng2) = x(rng)
        val randList = sequence(xs) // Rand[List[A]] = RNG => (List[A], RNG);
        val (t, rng3) = randList(rng2)
        (h :: t, rng3)
    }
  }

  // 6.8
  def flatMap[A, B](f: Rand[A])(g: A => Rand[B]): Rand[B] = { rng =>
    {
      val (x, rng2) = f(rng)
      val result = g(x) // RNG => (B, RNG)
      result(rng2)
    }
  }

  type MyState[S, +A] = S => (A, S)
  // case class MyState(run: S => (A, S))

  case class Moore[S, I, A](t: (S, I) => S, g: S => A)

  // type Moore[S, I, A] = S => (I => S, A)
  sealed trait Input
  case object Coin extends Input
  case object Turn extends Input

  case class Machine(locked: Boolean, candies: Int, coins: Int)

  /**
    * Rules:
        - Insert a coin into a locked machine will cause it to unlock if there any candies left.
        - Turn the knob on an unlocked machine will cause it to dispensate candy and become locked.
        - Turn the knob on a locked machine or inserting a coin into an unlocked machine does nothing.
        - A machine that's out of candy ignore all inputs.

        Goals:
        method simulateMachine should operate the machine based on the list of inputs and return
            the number of coins and candies left in the machine at the end.
            For example, if the input Machine has 10 coins and 5 candies, and a total of 4 candies are
            successfully bought the output should be (14, 1)
    */
  def simulateMachine(inputs: List[Input]): MyState[Machine, (Int, Int)] = {

    def processInput(input: Input): MyState[Machine, Unit] = { machine =>
      {
        if (machine.candies == 0) {
          ((), machine)
        } else {
          input match {
            case Coin
                if (machine.locked && machine.candies >= 0) => // val (h, rng2) = x(rng)
              ((), Machine(locked = false, machine.candies, machine.coins + 1))
            case Turn if (machine.locked && machine.candies >= 0) =>
              ((), Machine(locked = false, machine.candies - 1, machine.coins))
            case _ => ((), machine)
          }

        }
      }
    }

    // Helper functions
    // def map[A,B](s: MyState[A])(f: A => B): MyState[B] =

    def flatMap[S, A, B](s: MyState[S, A])(
        f: A => MyState[S, B]): MyState[S, B] = { state =>
      val (a, newState) = s(state)
      f(a)(newState)
    }

    // Sequence function for State operations
    def sequence[S, A](fs: List[MyState[S, A]]): MyState[S, List[A]] = {
      state =>
        fs match {
          case Nil => (Nil, state)
          case x :: xs =>
            val (h, state2) = x(state)
            val (t, state3) = sequence(xs)(state2)
            (h :: t, state3)
        }
    }

    val processed: MyState[Machine, List[Unit]] = sequence(
      inputs.map(i => processInput(i)))

    // val evenNumber: Rand[Int] = flatMap(nonNegativeInt)(n => rng => (n - n % 2, rng))
    flatMap(processed) { _ => machine =>
      ((machine.candies, machine.coins), machine)
    }
  }

}
