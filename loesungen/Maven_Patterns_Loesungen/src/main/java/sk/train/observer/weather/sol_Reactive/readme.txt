Umsetzung des Observer/Observable-Pattern
unter Nutzung des Publish/Subscribe-Ansatzes via Flow und SubmissionPublisher
(Bestandteil der JavaSE ab Version 9)

In diesem simplen Szenario weniger relevant, aber generell schon:
Es ist zu ber�cksichtigen, dass Erzeuger/Verbraucher (Observable/Observer) 
thread-technisch entkoppelt sind, und um �berlastung des Verbrauchers zu vermeiden 
Gegendruck erzeugt werden kann!

Der besseren Nachvollziehbarkeit zeige ich den jeweiligen ausf�hrenden Thread
auf System.error an.