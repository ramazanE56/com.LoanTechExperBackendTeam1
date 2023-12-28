Feature: Database üzerinden students tablosundaki
  firstname= Brian ve
  lastname= Kohlar olan öğrencinin
  email bilgisinin brain@gmail.com olduğunu doğrulayınız.

  @db02
  Scenario: Students tablosundaki ogrencilerin email bilgisi dogrulama testi.

    * Query hazirlanir ve students tablosuna execute edilir.
    * Students tablosundan donen resultSet`teki email bilgisi dogrulanir.


