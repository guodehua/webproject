$(function() {
	$('#btnsave').on('click',function(){
		$.ajax({
			data:$('#f1').serialize(),
			type:'POST',
			url:'/webproject/userservlet.do?type=add',
			success:function(data){
				if(data=='1'){
					$('#f1').form('clear');
					$('#dialog').dialog('close');
					$('#tb').datagrid('reload');
				}else{
					$('#sp').html("可以使用")	
				}
			}
		});
	})
	$('#tb').datagrid({
		url:'/webproject/userservlet.do',
		title:'用户信息',
		iconCls:'icon-ok',
		rownumbers:true,   //列编号
		singleSelect:true,   //只可以选中一行
		collapsible:true,
		queryParams:{type:'list'},
		toolbar: [{    //编辑
			iconCls: 'icon-edit',
			handler: editFunction	
		},'-',{
			iconCls: 'icon-add',
			handler: function(){//增加
				$('#f1').form('clear');
				$('#dialog').dialog('open');
			}
		},'-',{
			iconCls: 'icon-remove',
			handler: function(){	//删除
				var row = $('#tb').datagrid('getSelected');//返回选中的一行
				if (row!=null) {
					$.messager.confirm('删除确认','你确认要删除数据'+row.userid+'吗？',function(r){
						if (r) { //实现删除(通过ajax)
							$.ajax({
								   type: 'post',
								   url: '/webproject/userservlet.do',
								   data: {type:'remove',userid:row.userid},
								   success: function(msg){
								     if (msg=='1') {
										$.messager.alert('删除提示','删除成功','info');
										//重新刷新datagrid
										$('#tb').datagrid('reload');
									}
								     if (msg=='0') {
								    	 $.messager.alert('删除提示','无法删除','info');
										 //重新刷新datagrid
										 $('#tb').datagrid('reload');
									}
								   }
							});
						}
					})
					
				}
				if (row==null) {
					$.messager.alert('删除提示','请选择要删除的行','info');
				}
			}
		}],
		columns:[[
			{field:'chk',checkbox:true},//复选框
			{field:'userid',title:'用户编号'},
			{field:'uname',title:'账户'},
			{field:'upassword',title:'密码'},
			{field:'usex',title:'性别'},
			{field:'utel',title:'电话'},
			{field:'uemail',title:'邮箱'},
			{field:'uaddress',title:'地址'},
			{field:'ustateid',title:'用户状态'}
		]]
	});
})
function editFunction(){ 
	var row = $('#tb').datagrid('getSelected');
	if(row!=null){
		//$.messager.alert('错误',row.uemail,'warning');
		$('#uemail').textbox('setValue',row.uemail);
		$('#uemail').textbox({disabled:true});
		$('#uaddress').textbox('setValue',row.uaddress);
		$('#utel').textbox('setValue',row.utel);
		$('#upassword').textbox('setValue',row.upassword);
		$('#uname').textbox('setValue',row.uname);
		$('#uname').textbox({disabled:true});
		$('#usex').textbox('setValue',row.usex);
		$('#dialog').dialog({
			closed:false,
			title:'编辑用户信息',
			reload:true,
			buttons:[{
				text:'保存修改',
				iconCls:'icon-save',
				handler:function(){
					var isValid = $('form').form('validate');
					if (isValid) {
						var datas = $('form').serialize() + '&type=updata'+'&uname='+row.uname;
						$.ajax({
							type:'post',
							url:'/webproject/userservlet.do',
							data:datas,
							success:function(data){
								if (data == '1') {
									$('#f1').form('clear');
									$('#atb').dialog('close');
									$('#tb').datagrid('reload');
									$.messager.alert('修改成功','用户信息修改成功','info');
								} else{
									$.messager.alert('修改失败','请重新修改或联系管理员','error');
								}
							}
						})
					} else {
						$.messager.alert('修改失败','有所填项未通过验证','info');
					}
				}
			
			}]
		
		})
		
	}else{
		$.messager.alert('错误','请选择要修改的数据行','warning');
	}
}
