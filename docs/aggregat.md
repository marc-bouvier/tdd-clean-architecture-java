C'est quoi un aggrégat

> Un ensemble d'entités qui partagent un même invariant.

> Ils n'ont pas de sens en dehors d'une **transaction**

Dans un use-case tu ne dois pas avoir 2 persist sur 2 repositories différents

Car ils ne devraient pas partager les mêmes invariants

(Un repo ne s'applique que du des root aggregate)


