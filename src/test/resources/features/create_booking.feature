#language: es
Característica: Validar la creación de un Booking

  Escenario: Validar creación de Booking y consulta del mismo por id
    Dado que hago login
    Cuando cree un nuevo book
    Entonces Validare que el bookingid no es nulo


