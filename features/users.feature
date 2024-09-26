# language: en
@users
Feature: Felhasználókhoz tartozó tesztek

@user-1-1 @user-1-2 @useradatok
Scenario: Felhasználói adatok megnyitása
	Given a rendszerben van már egy létező felhasználó
	When a felhasználó megnyitja a felhasználó adatai képernyőt
	Then a felhasználói adatok képernyő megnyílik
	And a felhasználói adatok megjelennek
	And a felhasználói név és a teljes név nem szerkeszthető

@user-2-1 @user-2-2 @user-2-3 @jelszo
Scenario: Jelszó módosítás
	Given a felhasználó a felhasználói adatok oldalon van
	When a felhasználó helyesen megadja a jelenlegi jelszót
	And a felhasználó megadja az új jelszót kétszer
	And a felhasználó a jelszó változtatás gombra nyom
	Then a jelszó módosítása sikeres

Scenario: Felhasználókhoz tartozó tesztek #3
	Given a felhasználó a felhasználói adatok oldalon van
	When a felhasználó hibásan adja meg a jelenlegi jelszót
	And a felhasználó megadja az új jelszót kétszer
	And a felhasználó a jelszó változtatás gombra nyom
	Then a felhasználó a régi jelszóval kapcsolatos hibaüzenetet kap
	And a jelszó módosítása sikertelen

Scenario: Felhasználókhoz tartozó tesztek #4
	Given a felhasználó a felhasználói adatok oldalon van
	When a felhasználó helyesen megadja a jelenlegi jelszót
	And a felhasználó egyszer adja meg jól az új jelszót
	And a felhasználó a jelszó változtatás gombra nyom
	Then a felhasználó az új jelszóval kapcsolatos hibaüzenetet kap
	And a jelszó módosítása sikertelen
