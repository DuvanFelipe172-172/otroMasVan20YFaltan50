<%-- 
    Document   : Autor
    Created on : 16/05/2021, 02:59:27 AM
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
            <<h3>Agregar Administrador</h3>
            <form action="ControllAutor" method="POST">
                <input type="submit" name="accion" value="Listar">
                <input type="submit" name="accion" value="Nuevo">
                //consulta controlador
                
            </form>
        </div>
        <div>
            <form action="ControllAutor" method="POST">
                ID:
                <input type="text" name="txtid"> <br>
                NOMBRE:
                <input type="text" name="txtnombre"> <br>
                CARGO:
                <input type="text" name="txtcargo"> <br>
                
                <input type="submit" name="accion" value="Guardar">
            </form>
        </div>
    </center>
        
    </body>
</html>
