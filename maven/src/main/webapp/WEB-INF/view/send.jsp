<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름: ${name1 } <br>
이메일: ${email1 } <br>
이름2: ${name2 } <br>
이메일2: ${email2 } <br>
번호2: ${no } <br>

커맨드 객체(request set)<br>
이름3: ${vo.name } <br>
이메일3: ${vo.email } <br>
번호3: ${vo.no } <br>

커맨드 객체(request set 없이)<br>
이름3: ${memberVO.name } <br>
이메일3: ${memberVO.email } <br>
번호3: ${memberVO.no } <br>

Request에서 set )<br>
아이디: ${id } <br>
</body>
</html>