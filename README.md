# Gondolat olvasó
## Feladat leírása:
A feladat egy kartya trükk elkészítése Netbeansben. Ahol a felhasználó kiválaszt egy kártyát
és 3 körön keresztül megadja melyik oszlopban szerepel. A program pedig kitalálja melyik kártyát választotta.
## Feladatok felosztása:
### Vera:
- Program elkészítése
### Tibi:
- Pakli osztály elkészítése
### Maja:
- Lap osztály elkészítése/ besegítés a másik két kód megírásában
## OOP:
```mermaid
---
config:
  layout: elk
---
classDiagram
direction TB
    class Lap {
	    -String ertek
	    -String szin
	    +Lap(String ertek, String szin)
	    +String getErtek()
	    +String getSzin()
	    +String megj()
    }

    class Pakli {
	    #Lap[] lapok
	    +Pakli()
	    +Pakli(int db)
	    -void feltolt()
	    +Lap[] getLapok()
	    +void kever(int valasztottOszlop)
	    +Lap ezVolt()
    }

    class Program {
	    -Scanner sc
	    +main(String[] args) void
	    -kirak(Pakli pakli) void
	    -melyik() int
	    -trukk(Pakli pakli) void
    }

    Pakli "1" *-- "21" Lap : contains
    Program ..> Pakli : uses
    Program ..> Lap : uses
```
