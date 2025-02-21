¡Entiendo, vamos a dejarlo bien pulido! Aquí tienes una versión mejorada del README para tu proyecto **Task Tracker CLI**:

---

# 🚀 Task Tracker CLI
Task Tracker CLI es una aplicación de línea de comandos construida en Java para gestionar tus tareas de forma sencilla y eficiente. ¡Organiza tus pendientes directamente desde la terminal y mantén el control de tus actividades!

---

## ⚙️ Funcionalidades
- **Crear tareas**: Agrega nuevas tareas con una descripción y un estado inicial (`todo`, `in-progress`, o `done`).
- **Actualizar tareas**: Modifica la descripción o el estado de una tarea existente.
- **Listar tareas**: Muestra todas las tareas o filtra por estado (`todo`, `in-progress`, `done`).
- **Marcar tareas**: Cambia el estado de una tarea a `in-progress` o `done` de manera rápida.
- **Eliminar tareas**: Elimina una tarea especificada por su ID.
- **Persistencia en JSON**: Las tareas se guardan en un archivo `tasks.json`, lo que permite mantener los datos entre sesiones.

---

## 🚀 Instalación y Ejecución
1. **Clona el repositorio**:
```bash
git clone [URL_DEL_REPOSITORIO]
cd task-tracker-cli
```

2. **Compila el proyecto**:
```bash
javac -cp "lib/jackson-core-2.15.2.jar:lib/jackson-databind-2.15.2.jar" src/*.java -d bin
```

3. **Ejecuta la aplicación**:
```bash
java -cp "bin:lib/jackson-core-2.15.2.jar:lib/jackson-databind-2.15.2.jar" Main
```

---

## 🚧 Tecnologías Utilizadas
- **Java 21**: Lenguaje de programación principal de la aplicación.
- **Jackson**: Biblioteca para la serialización y deserialización de datos en JSON.
- **IntelliJ IDEA**: Entorno de desarrollo integrado (IDE) utilizado para el desarrollo del proyecto.

---

## 📂 Estructura del Proyecto
```
task-tracker-cli/
│
├── src/                     # Código fuente del proyecto
│   ├── Main.java             # Punto de entrada de la aplicación
│   ├── controller/           # Controladores de la lógica de negocio
│   ├── model/                # Modelos de datos
│   └── repository/           # Acceso y manejo de datos
│
├── lib/                     # Librerías externas (Jackson)
│   ├── jackson-core-2.15.2.jar
│   └── jackson-databind-2.15.2.jar
│
└── tasks.json               # Archivo de almacenamiento de tareas
```

---

## 📘 Uso
Al iniciar la aplicación, podrás ver un menú interactivo con las siguientes opciones:
```
1. Crear una nueva tarea  
2. Listar todas las tareas  
3. Filtrar tareas por estado  
4. Actualizar una tarea existente  
5. Marcar tarea como In-Progress  
6. Marcar tarea como Done  
7. Eliminar una tarea  
8. Salir  
```

Simplemente ingresa el número de la opción deseada y sigue las instrucciones en pantalla.

---

## 🛠️ Mejoras y Contribuciones
¡Siempre hay espacio para mejorar! Algunas ideas para futuras versiones:
- **Soporte para fechas de vencimiento y recordatorios.**
- **Agregar etiquetas o categorías a las tareas.**
- **Integración con bases de datos en lugar de JSON.**

Si deseas contribuir, ¡siéntete libre de abrir un issue o enviar un pull request!

---

## 📄 Licencia
Este proyecto está bajo la Licencia MIT - consulta el archivo [LICENSE](LICENSE) para más detalles.

---

