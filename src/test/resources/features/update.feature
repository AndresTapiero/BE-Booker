#language: es
Característica: Validar la actualizacion parcial y completa

  Escenario: Validar creación de Booking y actualización de booking completo
    Dado que hago login
    Cuando cree un nuevo book
    Entonces al actualizar validare los atributos


  Escenario: Validar creación de Booking y actualización de booking por nombre y apellido
    Dado que hago login
    Cuando  cree un nuevo book
    Entonces al actualizar validare los atributos 'Andrew' y 'Tapi'