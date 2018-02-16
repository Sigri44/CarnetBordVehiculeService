<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="../jspf/head.jspf" %>
</head>
<body>
    <div class="container">
        <header class="row">
            <%@include file="../jspf/header.jspf" %>
        </header>
        <section>
            <div class="row">
                <form method="post" action="<%=request.getContextPath() %>/connexion">
                    <fieldset>
                        <legend>Connexion</legend>
                        <p>
                        <label for="email">Email :</label><input name="email" type="email" id="email" /><br />
                        <label for="password">Mot de Passe :</label><input type="password" name="password" id="password" />
                        </p>
                    </fieldset>
                    <p><input type="submit" value="Connexion" /></p>
                </form>
            </div> 
        </section>
        <aside>
            <div class="row">
               <%@include file="../jspf/menu.jspf" %>
            </div>
        </aside>
        <footer>
            <div class="row">
                <%@include file="../jspf/footer.jspf" %>
            </div> 
        </footer>
    </div>
</body>
</html>