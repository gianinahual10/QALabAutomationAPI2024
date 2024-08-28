@gestionOrden
Feature: Gestion de ordenes

  @crearOrden
  Scenario Outline: Crear orden
    When creo la orden con id <id>
    Then el codigo de respuesta es 200
    Examples:
      | id  |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |

  @consultarOrden
  Scenario Outline: Consultar orden
    Given la url "https://petstore.swagger.io/v2/store/order" del servicio
    When hago la consulta de la orden con id <id>
    Then el codigo de respuesta es 200
    And imprimo la orden
    Examples:
      | id  |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |

