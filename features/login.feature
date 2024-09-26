# language: en
# namespace: Login
@login
Feature: Bejelentkezés tesztek

@login-1-1 @login-1-2 @ritalogin
Scenario: Érvényes felhasználói adatokkal a bejelentkezés sikeres
	Given Login: a felhasználó a bejelentkezési felületen van
	When Login: a felhasználó érvényes felhasználói nevet ad meg
	And Login: a felhasználó érvényes jelszót ad meg
	And Login: a felhasználó megpróbál bejelentkezni
	Then Login: a bejelentkezés sikeres
	And Login: a felhasználó a főoldalra érkezik

@login-2-1 @ervenytelen
Scenario: Érvénytelen jelszóval a bejelentkezés sikertelen
	Given Login: a felhasználó a bejelentkezési felületen van
	When Login: a felhasználó érvényes felhasználói nevet ad meg
	And Login: a felhasználó érvénytelen jelszót ad meg
	And Login: a felhasználó megpróbál bejelentkezni
	Then Login: a bejelentkezés sikertelen
	And Login: a felhasználó érvénytelen felhasználói adatokkal kapcsolatos hibaüzenetet kap

@login-2-2 @sikeres
Scenario: Sikertelen bejelentkezés után sikeres bejelentkezés lehetséges
	Given Login: a felhasználó a bejelentkezési felületen van
	And Login: a felhasználó korábbi bejelentkezése sikertelen volt
	When Login: a felhasználó érvényes felhasználói nevet ad meg
	And Login: a felhasználó érvényes jelszót ad meg
	And Login: a felhasználó megpróbál bejelentkezni
	Then Login: a bejelentkezés sikeres
	And Login: a felhasználó a főoldalra érkezik
