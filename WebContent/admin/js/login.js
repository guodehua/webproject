$(function() {
	
	$('#login').dialog({
		width:400,
		height:200,
		title:'用户登录',
		collapsible:true,
		iconCls:'icon-man',
		buttons:[{
			text:'登录',
			iconCls:'icon-ok',
			handler:function(){
				//判断表单是否通过验证
				var isValid = $('form').form('validate');
				if (isValid) {
					$.ajax({
						type:'post',
						date:$('form').serialize(),
						url:'/webproject/logincontroller.do',
						 data: {uloginid:$('#uloginid').val(),password:$('#password').val()},
						success:function(data){
							if (data=='1') {
								window.location='index.html';
							} else {
								$.messager.alert('验证出错了','表单验证未通过','info');
							}
						}
					})
				} else {
					$.messager.alert('验证出错了','表单验证未通过','info');
				}
			}
		},{
			text:'关闭',
			handler:function(){}
		}]
	});
})