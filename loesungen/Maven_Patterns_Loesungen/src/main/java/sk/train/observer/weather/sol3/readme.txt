Umsetzung des Observer/Observable-Pattern:
 
Nutzung des PropertyChangeListener-Ansatzes aus dem Package java.beans.
Dieser Ansatz beruht auf dem feuern von PropertyChangeEvents beruht, die sowohl 
den vorherigen Wert als auch den aktualisierten Wert übermitteln.
Zusätzlich ist ein Kopieren der Werte erforderlich (Referenzensemantik hilft hier nicht),
da die Events nur gefeuert werden, wenn sich alte und neue Werte unterscheiden.