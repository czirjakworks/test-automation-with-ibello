# language: en
# namespace: Cases
@cases
Feature: Ügyekhez tartozó tesztek

@cases-2-1 @cases-2-2 @cases-2-6 @cases-2-7 @jovo
Scenario: Jövőbeni érvényességi dátummal egy új ügy sikeresen rögzíthető
	Given Cases: a felhasználó az új ügy rögzítési felületen van
	And Cases: a felhasználó kitöltötte az összes adatot
	When Cases: a felhasználó a holnapi napot adja meg érvényességi időnek
	And Cases: a felhasználó elmenti az új ügyet
	Then Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: az új ügy megjelenik az ügyek táblázatban
	And Cases: az új ügy automatikusan kap azonosítót

@cases-1-3 @megnyitas
Scenario: Létező ügy megnyitása
	Given Cases: a rendszerben van már egy létező ügy
	And Cases: a felhasználó az ügyek oldalon van
	When Cases: a felhasználó megnyitja az ügyet
	Then Cases: az ügy szerkesztő oldala megnyílik
	And Cases: az ügy adatai megjelennek

@cases-1-1 @ugylista
Scenario: Ügyek listájának betöltése
	Given Cases: a rendszerben van már egy létező ügy
	When Cases: a felhasználó az ügyek oldalra lép
	Then Cases: az ügyek listájában megjelenik az összes ügy

@cases-1-2 @ujugy @ujmegnyitas
Scenario: Új ügy szerkesztésre megnyitása
	Given Cases: a felhasználó az ügyek oldalon van
	When Cases: a felhasználó az új ügy gombra nyom
	Then Cases: új ügy oldala megnyílik

@cases-2-3 @cases-2-4 @ujugy @ujellenorzes
Scenario: Új ügy adatellenőrzése
	Given Cases: a felhasználó az ügyek oldalon van
	When Cases: a felhasználó az új ügy gombra nyom
	Then Cases: új ügy oldala megnyílik
	And Cases: az ügy státusza Új
	And Cases: az ügy felelőse a felhasználó

@cases-2-5 @ujcancel
Scenario: Ügy rögzítésének megszakítása
	Given Cases: a felhasználó az új ügy rögzítési felületen van
	When Cases: a felhasználó a Mégsem gombra nyom
	Then Cases: a felhasználó visszatér az ügyek oldalra

@cases-3-2 @cases-3-3 @cases-3-6 @modositas
Scenario: Ügy adatainak módosítása
	Given Cases: a rendszerben van már egy létező ügy
	And Cases: a felhasználó az ügy szerkesztése oldalon van
	When Cases: a felhasználó megváltoztatja az ügy alapadatait
	And Cases: a felhasználó megváltoztatja az ügy címét
	And Cases: a felhasználó elmenti az új ügyet
	Then Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: a megváltozott adatok láthatóak az ügynél

@cases-3-2 @cases-3-3 @cases-3-5 @modositascancel
Scenario: Ügy módosításának megszakítása
	Given Cases: a rendszerben van már egy létező ügy
	And Cases: a felhasználó az ügy szerkesztése oldalon van
	When Cases: a felhasználó megváltoztatja az ügy alapadatait
	And Cases: a felhasználó a Mégsem gombra nyom
	Then Cases: a felhasználó visszatér az ügyek oldalra
	And Cases: az eredeti adatok láthatóak az ügynél

@cases-3-1 @cases-3-4 @idfelelos
Scenario: Ügy azonosítója és felelőse nem módosítható
	Given Cases: a rendszerben van már egy létező ügy
	And Cases: a felhasználó az ügyek oldalon van
	When Cases: a felhasználó megnyitja az ügyet
	Then Cases: az ügy szerkesztő oldala megnyílik
	And Cases: az ügy azonosítója megjelenik
	And Cases: az ügy felelőse megjelenik
	And Cases: az azonosító és a felelős nem módosíthatóak
