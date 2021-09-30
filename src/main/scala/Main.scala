import zio.*

enum Example[-I, +O]:
  case Pure[A](value: A) extends Example[A, A]
  case Zip[I1, O1, I2, O2, RI, RO](a: Example[I1, O1], b: Example[I2, O2]) extends Example[RI, RO]

object Example:
  def pure[A](value: A): Example[A, A] = Example.Pure(value)

extension[I, O] (self: Example[I, O])
  def zip[I2, O2, RI, RO](other: Example[I2, O2])(using Unzippable.In[I, I2, RI], Zippable.Out[O, O2, RO]): Example[RI, RO] =
    Example.Zip(self, other)

def assertSameType[T](e: Example[T, T]): Example[T, T] = e

object Main extends App:
  import Example._

    val x = pure(1)
    val y = pure(2)

    val xy1 = x zip y
    val xy2 = pure(1) zip pure(2)

    val _ = assertSameType(xy1)
    val _ = assertSameType(xy2)
