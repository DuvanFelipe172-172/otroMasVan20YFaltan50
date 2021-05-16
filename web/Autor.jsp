<%-- 
    Document   : AddAutor
    Created on : 16/05/2021, 03:00:05 AM
    Author     : Duvan Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <center>
        <div>
            <<h3>Admin</h3> 
            <form action="ControllAutor" method="POST">
                <input type="submit" name="accion" value="Listar">
            </form>
        </div>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>CARGO</th>
                        
                    </tr>
                </thead>  
                <tbody>
                    <c:forEach var="dato" items="${datos}">
                    <tr>
                        <td>${dato.getId_autor()}</td>
                        <td>${dato.getNombre()}</td>
                        <td>${dato.getCargo()}</td>
                       
                        
                        <td>
                            <form action="ControllAutor" method="POST">
                                <input type="hidden" name="id" value="${dato.getId_autor()}">
                                <input type="submit" name="accion" value="Editar">
                                <input type="submit" name="accion" value="Borrar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </center>
        
        
    </body>
</html>
