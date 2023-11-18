#language: es
 Característica: Validar por medio de API la creación y actualización

  Escenario: Validar la creación y actualización del servicio book
    Dado que hago ping al endpoint con respuesta 201
    Cuando cuando cree, actualice con nombre 'Andrew' y apellido 'Tapi', elimine respondiendo 201
    Entonces validare que el flujo finalizo correctamente con mensaje 'Funciona perfecto'

