Umsetzung des Observer/Observable-Pattern

WeatherStation soll das Observable sein, welches die Wetterdaten bereit stellt. 
Ändern diese sich, sollen die Observer mit den Wetterdaten benachrichtigt werden (update), so dass diese anschließend 
die aktuellen Wetterdaten auswerten können (Display-Elemente).
Observer sollen sich sowohl registrieren als auch wieder deregistrieren können.