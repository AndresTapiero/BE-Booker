#language: es
 Característica: Validar por medio de API la creación y actualización

  Escenario: Validar la creación y actualización del servicio book
    Dado que hago ping al endpoint con con respuesta 201
    Cuando Cuando cree, actualice, elimine
    Entonces Validare que el flujo finalizo correctamente

