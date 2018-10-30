package whats_wrong

object WhatsWrong1 {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {

    override val city = "Paris"
  }

  Supporter.city //What does this print ?   
  Supporter.support //What does this print and why ? How to fix it ? 
}  


Answer : Paris,  because it is overrided
Answer : It does not print any value because the string shouble declared in the double quotes.
         2) If s is declared in the double qoutes then the ouput will be : s Ici c'est $city !
         3) If s is deleted then the ouput will be : Ici c'est $city !
