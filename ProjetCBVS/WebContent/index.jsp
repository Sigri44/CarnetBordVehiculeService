<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="../jspf/head.jspf" %>
</head>
<body>
    <div class="container">
        <header class="row">
        	<div class="col-xs-12 col-md-12 col-lg-12">
            	<%@include file="../jspf/header.jspf" %>
            </div> 
        </header>
        
        <div class="row">
	        <div class="col-xs-12 col-md-12 col-lg-10">
		        <section id="main">
		            <div class="row">
		            	<div>Ceci sera un premier graphique</div>
		            	<img src="<%=request.getContextPath() %>/img/600x300.svg" />
		            </div>
		            <div class="row">
		            	<div>Ceci est un second</div>
		            	<img src="<%=request.getContextPath() %>/img/600x300.svg" />
		            </div>
		            <div class="row">
		            	<div>Et un troisième</div>
		            	<img src="<%=request.getContextPath() %>/img/600x300.svg" />
		            </div>
		        </section>
			</div>
			
			<div class="col-xs-12 col-md-12 col-lg-2">
				<div class="row">
					<aside id ="sidebar" class="col-xs-12 col-md-12 col-lg-12">
			            <div class="row">
			               <%@include file="../jspf/menu.jspf" %>
			            </div>
			        </aside>
				</div>
			</div>
		</div>
        
        <footer class="row">
        	<div class="col-xs-12 col-md-12 col-lg-12">
                <%@include file="../jspf/footer.jspf" %>
            </div> 
        </footer>
    </div>
</body>
</html>