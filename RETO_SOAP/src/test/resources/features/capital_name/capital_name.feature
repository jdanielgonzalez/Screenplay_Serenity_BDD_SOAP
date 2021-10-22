Feature: Nombre de la capital
  Como Estudiante de geografia
  necesito saber el nombre de la capital de un pais

  Background:
    Given el usuario necesita saber el nombre de la capital de un pais
  #escenario exitoso
  Scenario: codigo del pais correcto
    When el usuario ingresa de manera correcta el nombre: "FRANCIA"
    Then el ususario debería obtener el mensaje correcto "Paris"
  #escenario fallido
  Scenario: codigo del pais incorrecto
   When el usuario ingresa de manera incorrecta el nombre: "francia"
   Then el ususario debería obtener el mensaje incorrecto "Country not found in the database"