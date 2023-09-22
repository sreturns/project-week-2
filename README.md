
# Proyecto Semana 2

Este proyecto se basa en el desarrollo de una aplicación con Sprinboot y Thymeleaf.

Incluye un CRUD basico, e incorpora una API Rest muy sencilla.

Esta aplicación se ha hecho con la intención de ser ampliada a lo largo de las siguientes semanas.


## Authors

- [Sergio](https://www.github.com/sreturns)


## Tech Stack

 Thymeleaf, TailwindCSS

 Java, SpringBoot, Maven


## API Reference

#### Get all items

```http
  GET /api/cars
```


#### Get Car

```http
  GET /api/cars/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Car` | **Required**. Id of car to fetch 

#### Add Car

```http
  POST /api/cars/add
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Car`      |  | **Required**. Type Car object 

#### Update Car

```http
  POST /api/cars/update/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id, Car`      |  | **Required**. Type Car object 

#### Delete Car

```http
  DELETE /api/cars/delete/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      |  | **Required**. Id of car to fetch  

#### Get list Size

```http
  GET /api/cars/size
```

 


## Clone Respository

Para comenzar a trabajar con este proyecto, sigue estos pasos para clonar el repositorio en tu máquina local:

Abre tu terminal o línea de comandos.

Ejecuta el siguiente comando para clonar el repositorio:

   ```bash
   git clone git@github.com:sreturns/project-week-2.git
```
## Contributing

¡Las contribuciones son siempre bienvenidas!

Cambia al directorio del repositorio recién clonado:

```
cd tu-repositorio
```

Clona el repositorio como se describe arriba.

Crea una nueva rama para tu trabajo:

```
git checkout -b nombre-de-la-rama
```
Realiza tus cambios y haz commit:

```
git add .
git commit -m "Descripción de los cambios"
```

Envía tus cambios al repositorio remoto:
```
git push origin nombre-de-la-rama
```

## 🔗 Links
- [Project](https://www.github.com/sreturns/project-week-2)

