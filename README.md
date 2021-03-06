
# Redot Panda

Un bot en Java para Discord.

![Redot Panda](https://p1.pxfuel.com/preview/318/402/410/animal-themes-animal-wildlife-animal-red-panda-panda-animal-mammal-tree.jpg)

## Instalación

Este bot ha sido desarrollado en Java gracias a la librería [discord4j](https://discord4j.com/).

Para poder usarlo será necesario que te des de alta en el [Discord Developer Portal](https://discord.com/developers/applications) y consigas un token para tu bot. Sigue [este sencillo tutorial](https://docs.discord4j.com/discord-application-tutorial) si necesitas ayuda.

Una vez tengas tu token será tan sencillo como pegarlo en la constante *TOKEN* que hallarás en la clase *BotGateway*.

Debería quedar así:

```bash
 private final String TOKEN = "TOKEN";
```
Y listo, ya está todo preparado para que utilices tu bot de Discord!


## Funcionalidad con Google Drive

En la última versión este bot incluye la capacidad de ver el Drive de quien lanza el comando.

Para poder emplear la funcionalidad de Google Drive deberás dar de alta el proyecto en la consola de [Development de Google](https://developers.google.com/workspace/guides/create-project). Una vez dado de alta el proyecto, necesitarás [habilitar la API de Drive](https://developers.google.com/workspace/guides/enable-apis) y luego configurar el [*OAuth consent*](https://developers.google.com/workspace/guides/configure-oauth-consent).
Una vez configurado el *OAuth consent*, genera un *json* y colócalo en la carpeta *resources* del programa.

Listo, ahora tus usuarios podrán pasar por Discord imágenes que tengas almacenadas en tu Drive!
## Características

- Reacciona ante comandos de texto
- Utiliza *embeds* de Discord para mandar mensajes informativos o de error.
- Capacidad de listar y mandar las fotos de un directorio local desde donde se lance el programa.
- Capacidad de listar y mandar las fotos de una carpeta de Drive del usuario linkeado.


## *Roadmap*

- Optimizar código y facilitar instalación.


## FAQ

#### Cómo funcionan los comandos?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; El bot reconocerá como comando cualquier mensaje de Discord que empiece por "!".

#### Cómo sé que comandos tiene disponible el bot?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Para ver una lista de los comandos implementados actualmente, escribe "!help",

#### Cómo sé que hace cada comando?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Poniendo "!help !comando" el bot te dará una descripción breve de lo que hace cada comando.

#### Es el bot *case sensitive*?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; No, cualquier combinación de mayúsculas y minúsculas será válida siempre y cuando el comando esté bien escrito.

#### Qué fotos de Drive es capaz de listar el bot?

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; El bot está configurado para buscar fotos solo en la carpeta de Drive especificada y así no listar imágenes que el usuario no desee.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; El nombre de carpeta configurado por defecto es <b>*"fotosBot"*</b>. Si se desea cambiar la carpeta donde el bot va a buscar imágenes, cambia la constante <b>*FOLDER_NAME*</b>.

```bash
 public final static String FOLDER_NAME = "fotosBot";
```


