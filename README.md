# App - Spring boot - Angular

Alexander Londoño Espejo

# Instrucciones de ejecución Frontend

* **Angular**

1. 	Entrar en la carpeta **angular**
2. Ejecutar el comando **npm install**
3. Ejecutar la aplicación **ng serve**
4. Abrir el navegar **http://localhost:4200/**
5. Opción **Clients**: Puede ver el listado de clientes
6. Opción **Clients Add**: Puede agregar los nuevos clientes.


# Instrucciones de ejecución Backend

* **Java - Spring Boot**
1. 	Abrir aplicación en **Eclipse IDE / Spring Tools Suite**
2. Click Derecho en el proyecto -> Maven ->Update Project: Para que instale las dependencias
3. Click Derecho en el proyecto -> Run As -> Run on Server o Spring Boot App si se ejecutara en Spring Suite
4. Abrir aplicación Postman para probar el servcio
5. GET **http://localhost:8080/api/v1/clients**
6. POST **http://localhost:8080/api/v1/clients**
7. 
**Json:
{
    "birthdate":"01-12-2019",
    "firstname":"test",
    "lastname":"test",
    "identification":"123"
}**

# Información aplicación Angular


* **app/client** : Componente para listar los clientes resgitrados previamente.

* **app/client-add**: Componente para crear un cliente nuevo

Model

* **app/model**

Services

* **app/services**

# Información aplicación Java


# Plantilla utilizada
[https://www.creative-tim.com/product/material-dashboard-angular2]()






