# Factory

Pentru realizare magazinului am folosit Factory pentru metodele de plata (cash, transferbancar, card), astfel codul fiind mai usor de actualizat in cazul in care vreau sa adaug metode de plata noi sau date membre noi tipului de plata (IBAN, ultimele 4 cifre Card).<br>
Pentru adaugarea unei metode noi de plata trebuie adaugata o conditie in clasa Client in metoda cumparaDinMagazin si o clasa noua care sa extinda TipPlataAbstract.