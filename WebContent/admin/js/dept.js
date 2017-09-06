$(function() {
	$('#ide').dialog({
		toolbar:[{
			text:'保存修改',
			iconCls:'icon-save',
			handler:savefunction
		}]
	});
	$('#tt').datagrid({
		url:'/webproject/publisherController.do?&type=list',
		title:'出版社信息',
		iconCls:'icon-ok',
		rownumbers:true,//列编号
		//queryParams: {cid: cid},
		collapsible:true, //折叠按钮
		toolbar: [{
			iconCls: 'icon-add',
			handler: function(){
				$('#ide').dialog('open');
				
			}
		},'-',{
			iconCls: 'icon-remove',
			handler: function(){
				var row = $('#tt').datagrid('getSelected');//返回选中的一行
				if (row!=null) {
					$.messager.confirm('删除确认','你确认要删除数据'+row.userid+'吗？',function(r){
						if (r) { //实现删除(通过ajax)
							$.ajax({
								   type: 'post',
								   url: '/webproject/publisherController.do',
								   data: {type:'remove',pid:row.pid},
								   success: function(msg){
								     if (msg=='1') {
										$.messager.alert('删除提示','删除成功','info');
										//重新刷新datagrid
										$('#tt').datagrid('reload');
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

		columns:[[      //用表格展示数据
			{field:'chk',checkbox:true},//复选框
			{field:'pid',title:'出版社编号'},
			{field:'pname',title:'出版社名称'}
		]],
	});
})
function savefunction() {
	var pid = $('#pid').textbox('getText');
	var pname = $('#pname').textbox('getText');
	$.ajax({
		url:"/webproject/publisherController.do",
		type:'post',
		data:"pid="+pid+"&pname="+pname+"&type=add",
		success:function(msg){
			if (msg>0) {
				alert("添加成功");
				$('#ide').dialog('close');
				$('#tt').datagrid('reload');
			} else {
				alert("价格修改失败");
			}
		}
	});
}