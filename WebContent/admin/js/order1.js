$(function() {
	$('#tt').datagrid({ 
	title:'DataGrid - GroupView', 
	width:1000, 
	height:500, 
	rownumbers:true, 
	remoteSort:false, 
	nowrap:false, 
	fitColumns:true, 
	url:'/webproject/orderController.do', 
	columns:[[ 
		{field:'orderDetailId',title:'orderDetailId',width:200,sortable:true}, 
		{field:'gtitle',title:'gtitle',width:200,align:'right',sortable:true}, 
		{field:'gsalprice',title:'gsalprice',width:80,align:'right',sortable:true}, 
		{field:'gnumber',title:'gnumber',width:150,sortable:true}, 
		{field:'orderid',title:'orderid',width:200,align:'center'} 
	]], 
	groupField:'orderid', 
	view: groupview, 
	groupFormatter:function(value, rows){ 
		return value + ' - ' + rows.length + ' Item(s)'; 
	} 
	});

})