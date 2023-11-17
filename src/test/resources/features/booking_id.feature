#language: es
Característica: Validar booking por id

  Escenario: Validar creación de Booking y consulta del mismo por id
    Dado Que creo un nuevo book
    Cuando Valide en el servicio booking por id
    Entonces Validare la respuesta por el firstname


