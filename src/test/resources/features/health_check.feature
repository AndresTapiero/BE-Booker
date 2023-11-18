#language: es
Característica: Validar por pin que el endpoint esta corriendo

  Escenario: Validar el correcto funcionamiento del endpoint
    Dado que hago ping al endpoint con respuesta 201
    Entonces validare el mensaje 'Created'


