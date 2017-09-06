<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/ajax/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#uname').on('input',function(){
			//通过服务器请求资源
			$.ajax({
				data:{'uname':$(this).val()},
				type:'GET',
				url:'/webproject/checkname.do',
				success:function(data){
					if(data=='1'){
						$('span:first').html("已被注册")
					}else{
						$('span:first').html("可以使用")	
					}
				}
			});
		})
	})

</script>

<title>Insert title here</title>
</head>
<body>
	账号：<input type="text" id="uname"><span></span><br>
	邮箱：<input type="text" id="upassword"><span></span><br>
</body>
</html>