Umsetzung des Observer/Observable-Pattern

WeatherStation soll das Observable sein, welches die Wetterdaten bereit stellt. 
�ndern diese sich, sollen die Observer mit den Wetterdaten benachrichtigt werden (update), so dass diese anschlie�end 
die aktuellen Wetterdaten auswerten k�nnen (Display-Elemente).
Observer sollen sich sowohl registrieren als auch wieder deregistrieren k�nnen.