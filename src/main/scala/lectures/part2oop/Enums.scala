package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if (this == READ) println("opening document...")
      else println("reading not allowed.")
  }

  val somePermissions: Permissions = Permissions.READ

  // constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

//  object PermissionsWithBits {
//    def fromBits(bits: Int): PermissionsWithBits = // whatever
//      PermissionsWithBits.NONE
//  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = bits match {
      case 4 => PermissionsWithBits.READ
      case 2 => PermissionsWithBits.WRITE
      case 1 => PermissionsWithBits.EXECUTE
      case 0 => PermissionsWithBits.NONE
      case _ => throw new IllegalArgumentException(s"Unknown bits: $bits")
    }
  }

  // standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values // array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") // Permissions.READ

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument() // opening document...
    println(somePermissionsOrdinal) // 0
    println(Permissions.WRITE.toString) // WRITE

    val p = PermissionsWithBits.fromBits(4) // returns WRITE
    println(p) // READ
  }
}

