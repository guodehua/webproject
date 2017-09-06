$(function() {
	$('#cate').combobox({
		url:'/webproject/catecontroller.do',
		valueField:'cid',
		textField:'cname',
		onLoadSuccess:function(){
			var datas = $(this).combobox('getData'); //返回服务器发送的数据
			if (datas.length>0) {   //表示已经绑定了数据
				$(this).combobox('setValue',datas[0].cid);//设置下拉框初始值
				var cid =$('#cate').combobox('getValue');//取出初始值
				loadGoods(cid);//根据初始值加载数据
			}
		},
		onSelect:function(data){
			loadGoods(data.cid);
	}
			
	});
})
function loadGoods(cid) {
	$('#tb').datagrid({
		url:'/webproject/goodscontroller.do',
		title:'商品信息',
		iconCls:'icon-ok',
		pagination:true, //定义是否分页
		rownumbers:true,//列编号
		queryParams: {cid: cid},//发送给服务器的数据
		collapsible:true, //折叠按钮
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
		
		
	});
}