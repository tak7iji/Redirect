<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div id="wrapper">
        <h1>Hello world!</h1>
        <p>The time on the server is ${serverTime}.</p>
    </div>
    <div id="redirect">
    	<ul>
    		<li id="use"><a href="${pageContext.request.contextPath}/use">Use DefaultRedirectStrategy</a>
        	<li id="non"><a href="${pageContext.request.contextPath}/non">Use HttpServletResponse</a>
    	</ul>
    </div>
</body>
</html>
