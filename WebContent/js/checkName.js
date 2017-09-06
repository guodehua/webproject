
window.onload = function(){
document.querySelector('#check_user').onclick = function(){
	//将账号拿到，再传到服务器去验证，验证后拿到服务器返回的验证结果
	var uname = document.querySelector('#uname').value;
	
	//Ajax与服务器通信是通过XMLHttpRequest实现的；
	//1、得到一个异步通信的组件对象
	
	var xmlhttp = new XMLHttpRequest();
	//2、使用此对象与服务器通信
	//A、创建一个http请求（建立与服务器某一资源的通信）
	xmlhttp.open("GET",'/webproject/checkname.do?uname='+uname,true);
	//B、发送请求；
	//C、接收服务器返回的数据
	xmlhttp.onreadystatechange = function(){
		alert(xmlhttp);
		if(xmlhttp.readyState==4){
			if(xmlhttp.status==200){
				//可以取服务器返回的数据
				var date = xmlhttp.responseText;//接收服务器返回的字符串1,0
				var sp = document.querySelector('#sp');
				sp.innerHTML='账号已被注册';
				if(date=='1'){
					sp.innerHTML='账号已被注册';
					sp.style.color='red';
				}else{
					sp.innerHTML='恭喜，可以使用';
					sp.style.color='green';
				}
			
			}
		}
	}
}
}