MEJORA #1
UBICACION:InventarioServices
Descripción del cambio: Evitar que se registren productos con el mismo nombre
Justificación: Se creo una función que evalúa si el producto con ese nombre ya existe por medio de un valor booleano, si ya existe no se agrega.

MEJORA #2
UBICACION: Pedido, schema y DataBaseManager
Descripción del cambio: Registrar la fecha y hora de cada pedido
Justificación: Se cambio el parámetro de fecha directamente en la base de datos para que tome fecha y la hora del pedido directamente al agregarlo.