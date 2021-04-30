Observaciones:

- Se creó la clase ReparaFix para mantener todos los objetos del sistema y ofrecer algunas utilidades 
de búsqueda.

- La búsqueda de Servicios, Herramientas, etc. se hace con índices. Para ello se implementó la interface
Identificable. También se puede lanzar la excepción IdentificableNoEncontradoException. 

- La interface Contratable es implementada por Trabajo (en lugar de Servicio) y Alquiler. Un 
Servicio se concibe como algo "genérico" y el Trabajo como una instancia particular. Es por 
esto que lo que se contrata es un Trabajo, referido a un Servicio. Por ejemplo, un servicio 
puede ser "Colocación de gas de aire acondicionado", y el trabajo es "El técnico Juan Perez 
colocará gas a un aire acondicionado del cliente Federico Pacheco el 5/5/2021".

- Se optó por agregar TrabajoEstandar y TrabajoPersonalizado, para guardar los atributos 
que se detallan en el diagrama de clases.

- Se agregaron a algunas clases algunos atributos no detallados en el enunciado (por ejemplo,
horasTrabajadas para TrabajoEstandar, nombreUsuario, contrasenia, ... a Usuario).

- Para el cálculo del costo para TrabajoEstandar, se optó por aplicar la comisión del Trabajador al 
monto del ServicioEstandar y luego sumarle el costo por hora del Trabajador. A todo se le aplica un 
recargo por urgencia. 

- Las excepciones del inciso 7), por como está hecho el trabajo, no fueron implementadas:
	> OficioNoCoincideException no puede ocurrir porque la contratación (creación) del trabajo 
	ocurre en ServicioEstandar o ServicioPersonalizado con el Oficio que éstos tienen registrado,
	y la búsqueda del Trabajador con dicho Oficio se delega a la clase ReparaFix.
	> AgendaOcupadaException no tiene tanto sentido porque para la contratación de un Trabajo no
	se especifica el Trabajador específico que debe realizarlo. Siendo que ReparaFix efectúa la 
	búsqueda de un Trabajador con el Oficio del Servicio, se generarían excepciones cada vez que 
	el trabajador encontrado no tuviera la agenda libre. De esta suerte, esta excepción fue
	reemplazada por un comportamiento un poco más elaborado:
		* Si el Trabajo es urgente y no hay un Trabajador que pueda hacerlo ese día se lanza
		la excepción SinTrabajadoresDisponiblesException.
		* Si el Trabajo no es urgente y en el día en que lo pidió el usuario no hay ningún
		Trabajador disponible, se busca en los sucesivos días hasta encontrar un Trabajador
		con agenda libre, pactándose ese día (esto podría implementarse de otro modo, o 
		también lanzar SinTrabajadoresDisponiblesException).

- Se agregó la excepción HerramientaYaAlquiladaException. 



