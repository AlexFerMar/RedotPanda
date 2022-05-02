
# Redot Panda

Un bot en Java para Discord.

![Redot Panda](https://p1.pxfuel.com/preview/318/402/410/animal-themes-animal-wildlife-animal-red-panda-panda-animal-mammal-tree.jpg)

## Instalación

Este bot ha sido desarrollado en Java gracias a la librería [discord4j](https://discord4j.com/).

Para poder usarlo será necesario que te des de alta en el [Discord Developer Portal](https://discord.com/developers/applications) y consigas un token para tu bot. Sigue [este sencillo tutorial](https://docs.discord4j.com/discord-application-tutorial) si necesitas ayuda.

Una vez tengas tu token será tan sencillo como pegarlo en la constante *TOKEN* que hallarás en la clase *BotGateway*.

Debería quedar así:

```bash
 private final String TOKEN = "tu_token";
```
Y listo, ya está todo preparado para que utilices tu bot de Discord!

## Características

- Reacciona ante comandos de texto
- Utiliza *embeds* de Discord para mandar mensajes informativos o de error
- Capacidad de listar y mandar las fotos de un directorio local desde donde se lance el programa 
- Capacidad de listar y mandar las fotos de una carpeta de drive del usuario que lance el comando


## *Roadmap*

- Corregir errores de ortografía y optimizar el código
- Comentar el código para mejorar su legibilidad 
- Utilizar un fichero para almacenar el token de Discord 


## FAQ

#### Como funcionan los comandos?

El bot reconocerá como comando cualquier mensaje de Discord que empiece por "!".

#### Como sé que comandos tiene disponible el bot?

Para ver una lista de los comandos implementados actualmente, escribe "!help",

#### Como sé que hace cada comando?

Poniendo "!help !comando" el bot te dará una descripción breve de lo que hace cada comando.

#### Es el bot *case sensitive*?

No, cualquier combinación de mayúsculas y minúsculas será válida siempre y cuando el comando este bien escrito.
