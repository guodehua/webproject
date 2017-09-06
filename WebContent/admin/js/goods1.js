$(function() {
	$('#tt').datagrid({ 
		title:'DataGrid - DetailView', 
		width:500, 
		height:250, 
		//queryParams: {cid: cid},
		remoteSort:false, 
		pagination:true,
		singleSelect:true, 
		nowrap:false, 
		fitColumns:true, 
		url:'/webproject/goodscontroller.do', 
		columns:[[ 
			{field:'chk',checkbox:true},//复选框
			{field:'gId',title:'商品编号'},
			{field:'gTitle',title:'商品名称'},
			{field:'gAuthor',title:'作者'},
			{field:'gSaleprice',title:'售价'},
			{field:'gInprice',title:'进价'},
			{field:'gImg',title:'图片名称'},
			{field:'gClicks',title:'点击量'} 
		]], 
		view: detailview, 
		detailFormatter: function(rowIndex, rowData){ 
		return '<table><tr>' + 
		'<td rowspan=2 style="border:0"><img src="images/' + rowData.itemid + '.png" style="height:50px;"></td>' + 
		'<td style="border:0">' + 
		'<p>Attribute: ' + rowData.attr1 + '</p>' + 
		'<p>Status: ' + rowData.status + '</p>' + 
		'</td>' + 
		'</tr></table>'; 
		} 
		});

})