$(function() {
	$('#ide').dialog({
		toolbar:[{
			text:'保存修改',
			iconCls:'icon-save',
			handler:savefunction
		}]
	});
	$('#tt').datagrid({
		url:'/webproject/userservlet.do?&type=list',
		title:'用户权限',
		iconCls:'icon-ok',
		rownumbers:true,//列编号
		collapsible:true, //折叠按钮
		toolbar: [{
			iconCls: 'icon-edit',
			handler: function(){
				var row = $('#tt').datagrid('getSelected');//返回选中的一行
				if (row!=null) {
					$('#userid').textbox('setValue',row.userid);
					$('#userid').textbox({disabled:true});
					$('#uname').textbox('setValue',row.uname);
					$('#uname').textbox({disabled:true});
					$('#ustateid').textbox('setValue',row.ustateid);
					$('#ide').dialog('open');
				}else {
					$.messager.alert('编辑提示','请选择要修改的行','info');
				}
			}
		}],
		columns:[[      //用表格展示数据
			{field:'chk',checkbox:true},//复选框
			{field:'userid',title:'用户编号'},
			{field:'uname',title:'账号'},
			{field:'ustateid',title:'状态'}
		]]
	});
})
function savefunction(){
	var uname = $('#uname').textbox('getText');
	var ustateid = $('#ustateid').textbox('getText');
	$.ajax({
		url:"/webproject/userservlet.do",
		type:'post',
		data:"uname="+uname+"&ustateid="+ustateid+"&type=add",
		success:function(msg){
			if (msg>0) {
				alert("授权成功");
				$('#ide').dialog('close');
				$('#tt').datagrid('reload');
			} else {
				alert("授权失败");
			}
		}
	});
}