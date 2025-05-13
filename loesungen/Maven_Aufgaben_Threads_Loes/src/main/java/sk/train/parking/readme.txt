Diese Parkhaus-Implementierung wird mit hoher Wahrscheinlichkeit einen Deadlock verursachen.

1) Nutzen Sie wait/notify zur Deadlock-Vermeidung.

2) Weitere Möglichkeit: Nutzen Sie ein Semaphor zur Vermeidung des Deadlocks.