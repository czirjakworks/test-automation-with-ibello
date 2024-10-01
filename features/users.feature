# language: en
# namespace: User
@users
Feature: Felhasználókhoz tartozó tesztek

@user-1-1 @user-1-2 @useradatok
Scenario: Felhasználói adatok megnyitása
	Given User: a felhasználó a felhasználói adatok oldalon van
	When User: a felhasználó ellenőrzi az adatokat
	Then User: a felhasználói adatok megjelennek
	And User: a felhasználói név és a teljes név nem szerkeszthető

@user-2-1 @user-2-2 @user-2-3 @jelszomodositas
Scenario: Jelszó módosítás
	Given User: a felhasználó a felhasználói adatok oldalon van
	When User: a felhasználó helyesen megadja a jelenlegi jelszót
	And User: a felhasználó megadja az új jelszót kétszer
	And User: a felhasználó a jelszó változtatás gombra nyom
	Then User: a jelszó módosítása sikeres

@user-2-1 @user-2-2 @user-2-3 @regijelszo
Scenario: Hibás régi jelszó
	Given User: a felhasználó a felhasználói adatok oldalon van
	When User: a felhasználó hibásan adja meg a jelenlegi jelszót
	And User: a felhasználó megadja az új jelszót kétszer
	And User: a felhasználó a jelszó változtatás gombra nyom
	Then User: a felhasználó a régi jelszóval kapcsolatos hibaüzenetet kap
	And User: a jelszó módosítása sikertelen hibás jelenlegi jelszó esetén

@user-2-1 @user-2-2 @user-2-3 @ujjelszo
Scenario: Hibás új jelszó
	Given User: a felhasználó a felhasználói adatok oldalon van
	When User: a felhasználó helyesen megadja a jelenlegi jelszót
	And User: a felhasználó egyszer adja meg jól az új jelszót
	And User: a felhasználó a jelszó változtatás gombra nyom
	Then User: a felhasználó az új jelszóval kapcsolatos hibaüzenetet kap
	And User: a jelszó módosítása sikertelen hibás új jelszó esetén
