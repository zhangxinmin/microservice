<%@page language="java"  contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
<head></head>

<body>
 <h1>文件上传</h1>
<form action="upload" enctype="multipart/form-data" method="post">
 <input type="file" name ="file">
 <input type="submit" value="上传">
</form>
</body>


</html>