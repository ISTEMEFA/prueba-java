<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
    <title>Busqueda de Peliculas</title>
</head>
<body>

<div class="container">
    <!-- -->
    <h1>Busqueda de Peliculas</h1>
    <!--formulario -->
    <form action="/seach" method="post">
        <div class="row">
            <div class="col">
                <label for="category" class="form-label">Categoria</label>
                <select name="category" id="category" class="form-select">
                    <c:forEach items="${categoryList}" var="categoryList">
                        <option value="${categoryList.category_id}">${categoryList.name}</option>
                    </c:forEach></select>
            </div>
            <div class="col">
                <label for="films" class="form-label">Titulo</label>
                <div class="col">
                    <input type="text" class="form-control" name="films"
                           id="films">
                </div>
            </div>

            <div class="col">
                <p></p>
                <button type="submit" class="btn btn-primary">Buscar</button>
            </div>
        </div>
    </form>

    <!--tabla -->
    <br>
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>

                <th scope="col">Categoria</th>
                <th scope="col">ID Films</th>
                <th scope="col">Titulo</th>
                <th scope="col">Duracion</th>
                <th scope="col">Rating</th>
                <th scope="col">Precio</th>
                <th scope="col">Duracion Arriendo</th>
                <th>Accion</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${filmCategory}" var="filmsList">

                <tr>
                    <td>${filmsList.category.name}</td>
                    <td >${filmsList.film.film_id}</td>
                    <td>${filmsList.film.title}</td>
                    <td>${filmsList.film.length}</td>
                    <td>${filmsList.film.rating}</td>
                    <td>${filmsList.film.replacement_cost}</td>
                    <td>${filmsList.film.rental_duration}</td>
                    <td> <a class="btn btn-primary" href="#">Ver</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<script
        src=" ://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>