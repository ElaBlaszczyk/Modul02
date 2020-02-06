Feature: Zakupy

  Scenario: Zakup Hummingbird Printed Sweater

    Given Uzytkownik loguje sie na swoje konto
    When Uzytkownik w polu wyszukaj wpisuje Hummingbird Printed Sweater
    And Uzytkownik wybiera Hummingbird Printed Sweater
    And Uzytkownik wybiera rozmiar M
    And Uzytkownik wybiera ilosc sztuk 5szt
    And Uzytkownik dodaje produkt do koszyka
    And Uzytkownik przechodzi do opcji checkout
    And Uzytkownik potwierdza adres
    And Uzytkownik wybiera metode odbioru PrestaShop z opcji shipping method
    And Uzytkownik przechodzi do opcji payment
    And Uzytkownik wybiera metode odbioru Pay by Check
    And Uzytkownik akceptuje regulamin
    And Uzytkownik zatwierdza zamowienie
    And Uzytkownik robi screenshot z potwierdzeniem zamowienia i kwota
    Then Zakup zostal dokonany

