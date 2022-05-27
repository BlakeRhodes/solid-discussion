fun main(args: Array<String>) {
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")
}
/*
 _______   __         ______   __    __  ________        _______   __    __   ______   _______   ________   ______
/       \ /  |       /      \ /  |  /  |/        |      /       \ /  |  /  | /      \ /       \ /        | /      \
$$$$$$$  |$$ |      /$$$$$$  |$$ | /$$/ $$$$$$$$/       $$$$$$$  |$$ |  $$ |/$$$$$$  |$$$$$$$  |$$$$$$$$/ /$$$$$$  |
$$ |__$$ |$$ |      $$ |__$$ |$$ |/$$/  $$ |__          $$ |__$$ |$$ |__$$ |$$ |  $$ |$$ |  $$ |$$ |__    $$ \__$$/
$$    $$< $$ |      $$    $$ |$$  $$<   $$    |         $$    $$< $$    $$ |$$ |  $$ |$$ |  $$ |$$    |   $$      \
$$$$$$$  |$$ |      $$$$$$$$ |$$$$$  \  $$$$$/          $$$$$$$  |$$$$$$$$ |$$ |  $$ |$$ |  $$ |$$$$$/     $$$$$$  |
$$ |__$$ |$$ |_____ $$ |  $$ |$$ |$$  \ $$ |_____       $$ |  $$ |$$ |  $$ |$$ \__$$ |$$ |__$$ |$$ |_____ /  \__$$ |
$$    $$/ $$       |$$ |  $$ |$$ | $$  |$$       |      $$ |  $$ |$$ |  $$ |$$    $$/ $$    $$/ $$       |$$    $$/
$$$$$$$/  $$$$$$$$/ $$/   $$/ $$/   $$/ $$$$$$$$/       $$/   $$/ $$/   $$/  $$$$$$/  $$$$$$$/  $$$$$$$$/  $$$$$$/

Impressive Programmer, Many Titles, creator of rotato.dev, and Kotlin Nut


 */


/* Object-Oriented Programming

    A programing paradigm focusing on
        encapsulation, abstraction, inheritance, and polymorphism.

    Encapsulation - State and the ability to mutate it are encapsulated into objects. This lends itself to simulation
    and data focused applications

    Abstraction - Implementation details are hidden away, so that only high level functions are exposed. This eases the
    maintenance of large code bases.

    Inheritance - Shared logic is encapsulated by a hierarchy of related objects. Parent-Child relationships are used
    to express this hierarchy.

    Polymorphism - Different objects can be grouped together based on their types. Many shapes of
    data can be handled by a single expression.
*/
/*
    But . . .
                Sometimes it gets complicated, if only we had some design principles to guide us.
*/

/* Luckily we have
   SSSSSSSSSSSSSSS              OOOOOOOOO             LLLLLLLLLLL                     IIIIIIIIII        DDDDDDDDDDDDD        
 SS:::::::::::::::S           OO:::::::::OO   c        L:::::::::L                     I::::::::I        D::::::::::::DDD
S:::::SSSSSS::::::S         OO:::::::::::::OO         L:::::::::L                     I::::::::I        D:::::::::::::::DD   
S:::::S     SSSSSSS        O:::::::OOO:::::::O        LL:::::::LL                     II::::::II        DDD:::::DDDDD:::::D  
S:::::S                    O::::::O   O::::::O          L:::::L                         I::::I            D:::::D    D:::::D 
S:::::S                    O:::::O     O:::::O          L:::::L                         I::::I            D:::::D     D:::::D
 S::::SSSS                 O:::::O     O:::::O          L:::::L                         I::::I            D:::::D     D:::::D
  SS::::::SSSSS            O:::::O     O:::::O          L:::::L                         I::::I            D:::::D     D:::::D
    SSS::::::::SS          O:::::O     O:::::O          L:::::L                         I::::I            D:::::D     D:::::D
       SSSSSS::::S         O:::::O     O:::::O          L:::::L                         I::::I            D:::::D     D:::::D
            S:::::S        O:::::O     O:::::O          L:::::L                         I::::I            D:::::D     D:::::D
            S:::::S        O::::::O   O::::::O          L:::::L         LLLLLL          I::::I            D:::::D    D:::::D 
SSSSSSS     S:::::S        O:::::::OOO:::::::O        LL:::::::LLLLLLLLL:::::L        II::::::II        DDD:::::DDDDD:::::D  
S::::::SSSSSS:::::S ......  OO:::::::::::::OO  ...... L::::::::::::::::::::::L ...... I::::::::I ...... D:::::::::::::::DD   
S:::::::::::::::SS  .::::.    OO:::::::::OO    .::::. L::::::::::::::::::::::L .::::. I::::::::I .::::. D::::::::::::DDD     
 SSSSSSSSSSSSSSS    ......      OOOOOOOOO      ...... LLLLLLLLLLLLLLLLLLLLLLLL ...... IIIIIIIIII ...... DDDDDDDDDDDDD
 */


/*
Clearly this is where we ask what that is, or who that be?
    And it is . . .

Five design principles intended to make OOP software designs more understandable, flexible, and maintainable.
    1. Single Responsibility
    2. Open-Closed
    3. Liskov's Substitution
    4. Interface Segregation
    5. Dependency Inversion

    Summed up in a quote
                            "Do it good, and not bad." Uncle Bob (probably)
*/


// Single Responsibility: A class or method or whatever should have one and only one reason to change,
// meaning that a class should have only one job.

data class Drink(val name: String)
data class IceCube(val size: Int)
data class Strainer(val name: String)
data class Ingredient(val name: String)

// Does too much
class DilutionAndIceService {
    fun stir(time: Int, iceCubes: List<IceCube>, strainer: Strainer): Drink {
        TODO("code that stirs")
    }

    fun shake(time: Int, iceCubes: List<IceCube>, addIns: List<Ingredient>): Drink {
        TODO("code that shakes")
    }

    fun makeIce(): List<IceCube> {
        TODO("code that makes ice")
    }

    fun crackIce(ice: IceCube): IceCube {
        TODO("code that cracks ice")
    }
}

// Pull out the ice stuff
class DilutionService {
    fun stir(time: Int, iceCubes: List<IceCube>, strainer: Strainer): Drink {
        TODO("code that stirs")
    }

    fun shake(time: Int, iceCubes: List<IceCube>, addIns: List<Ingredient>): Drink {
        TODO("code that shakes")
    }
}

class IceService {
    fun makeIce(): List<IceCube> {
        TODO("code that makes ice")
    }

    fun crackIce(ice: IceCube): IceCube {
        TODO("code that cracks ice")
    }
}

// Too far
class StirService {
    fun stir(time: Int, iceCubes: List<IceCube>, strainer: Strainer): Drink {
        TODO("code that stirs")
    }
}

class ShakeService {
    fun shake(time: Int, iceCubes: List<IceCube>, addIns: List<Ingredient>): Drink {
        TODO("code that shakes")
    }
}

class IceMakerService {
    fun makeIce(): List<IceCube> {
        TODO("code that makes ice")
    }
}

class IceCrackerService {
    fun crackIce(ice: IceCube): IceCube {
        TODO("code that cracks ice")
    }
}

// Open for Extension-Closed for Modifications
interface Garnish {
    fun prepare()
}

class Cherry : Garnish {
    override fun prepare() {
        TODO("code that prepares the garnish")
    }
}

class OrangeSlice : Garnish {
    override fun prepare() {
        TODO("code that prepares the garnish")
    }
}

// Open for modification
class QuestionableGarnishService {
    fun garnish(drink: Drink, garnish: Garnish): Drink {
        when(garnish) {
            is Cherry -> TODO("code that does the cherry garnishing")
            is OrangeSlice -> TODO("code that does the orange slice garnishing")
        }
        TODO("the rest of your code")
    }
}

// Closed for modification, Open for extension
class LimeWedge : Garnish {
    override fun prepare() {
        TODO("code that prepares the garnish")
    }
}

open class GarnishService {
    fun garnish(drink: Drink, garnish: Garnish): Drink {
        garnish.prepare()
        TODO("the rest of the code")
    }
}

class TikiGarnishService : GarnishService() {
    fun putInTikiGlass(drink: Drink, garnish: Garnish): Drink {
        val garnishedDrink = garnish(drink, garnish)

        TODO("code to put the drink in a sweet tiki mug, like a classic deuce or a parrot")
    }
}


/*
    Liskov's Substitution

        Let Φ(x) be a property provable about objects x of type T.
        Then Φ(y) should be true for objects y of type S where S is a subtype of T.

or . . .

        If you can do a thing to one thing, you should be able to do that same thing to a derived thing.
*/


open class TablePrep {
    open fun prepare(drink: Drink): Drink {
        TODO("code that prepares the drink table side")
    }

    open fun flair(drink: Drink): Drink {
        TODO("code that prepares the drink, with much flair")
    }
}

class FlamingDrink : TablePrep() {
    override fun prepare(drink: Drink): Drink {
        TODO("code that prepares the drink table side")
    }

    override fun flair(drink: Drink): Drink {
        TODO("code that prepares the drink, with much fire")
    }
}

//class FreshCutFruit: TablePrep {
//    override fun prepare(drink: Drink): Drink {
//        TODO("code that prepares the drink table side")
//    }
//}

//can't prepare FreshCutFruit
class TableSidePreparer {
    fun prep(tablePrep: TablePrep, drink: Drink): Drink {
        return tablePrep.flair(
            tablePrep.prepare(drink)
        )
    }
}

// Using Liskov Substitution

open class BarPrep {
    fun prepare(drink: Drink): Drink {
        TODO("code that prepares the drink table side")
    }
}

open class BarFlair : BarPrep() {
    fun flair(drink: Drink): Drink {
        TODO("code that prepares the drink table side")
    }
}

class BarFreshFruit : BarPrep()
class BarFlaming : BarFlair()
class BarTrickPour : BarFlair()

class BarPreparer {
    fun prep(prep: BarPrep, drink: Drink): Drink {
        return prep.prepare(drink)
    }

    fun flairPrep(prep: BarFlair, drink: Drink): Drink {
        return prep.flair(prep.flair(drink))
    }
}


/* Interface Segregation
        No code should be forced to depend on methods it does not use.
                                                                - John Duns Scotus (If they were alive)
*/

//No segregation
interface Mixer {
    fun mix(drink: Drink): Drink
    fun muddle(drink: Drink): Drink
    fun blend(drink: Drink): Drink
}

class Blender : Mixer {
    override fun mix(drink: Drink): Drink {
        TODO("code to mix the drink")
    }

    override fun blend(drink: Drink): Drink {
        TODO("code to blend the drink")
    }

    override fun muddle(drink: Drink): Drink = throw (RuntimeException("can't muddle, use a different Mixer"))
}

// Segregation used correctly

interface Refrigerator {
    fun cool()
    fun freeze()
}

interface WaterDespencer {
    fun pourWater()
}

class CheapFridge : Refrigerator {
    override fun cool() {
        TODO("code that cools")
    }

    override fun freeze() {
        TODO("code that freezes")
    }
}

class NiceFridge : Refrigerator, WaterDespencer {
    override fun cool() {
        TODO("code that cools")
    }

    override fun freeze() {
        TODO("code that freezes")
    }

    override fun pourWater() {
        TODO("code that pours water")
    }
}

/* Dependency Inversion - It's not Dependency Injection, but Dependency Injection is Dependency Inversion
High-level objects should not depend on low-level objects. Both should depend on abstractions that do
not depend on details. Details should depend on abstractions. */

class Screen
class Recipe

interface Display {
    fun next(screen: Screen)
}

class SmallTv : Display {
    override fun next(screen: Screen) {
        TODO("code to make it readable")
    }
}

class LargeTv : Display {
    override fun next(screen: Screen) {
        TODO("code to make it readable")
    }
}

interface Formatter {
    fun format(recipe: Recipe): Screen
}

class Summary : Formatter {
    override fun format(recipe: Recipe): Screen {
        TODO("code that summarizes the recipe")
    }
}

class MenuItem : Formatter {
    override fun format(recipe: Recipe): Screen {
        TODO("code that formats the recipe")
    }
}

class DisplayManager(
    val display: Display,
    val formatter: Formatter,
) {
    fun displayRecipe(recipe: Recipe) {
        display.next(
            formatter.format(recipe)
        )
    }
}