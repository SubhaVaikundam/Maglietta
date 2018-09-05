<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
      <link rel="stylesheet" type="text/css"
                href="${pageContext.request.contextPath}/css/style.css"/>
   </head>
   <body>
      <h1>Welcome</h1>
     <h2>${pageContext.request.contextPath}</h2>  
     
         
      <a href="http://localhost:9080/maglietta/api/v1/categories">Category List</a> 
       
   </body>
   
</html>