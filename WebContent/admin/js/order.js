$(function() {
	

$('#tt').datagrid({
		url:'/webproject/orderController.do',
		title:'订单信息',
		iconCls:'icon-ok',
		rownumbers:true,//列编号
		//queryParams: {cid: cid},
		collapsible:true, //折叠按钮
		columns:[[      //用表格展示数据
			//{field:'chk',checkbox:true},//复选框
			{field:'orderId',title:'订单编号'},
			{field:'userId',title:'用户编号'},
			{field:'totalPrice',title:'交易价格'},
			{field:'orderDate',title:'交易时间'}
		]],
	});
})