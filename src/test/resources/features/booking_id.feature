#language: es
Característica: Validar booking por id

  Escenario: Validar creación de Booking y consulta del mismo por id
    Dado que hago login
    Cuando cree un nuevo book
    Entonces valide en el servicio booking por id
    Y validare la respuesta por el nombre 'Tom'


