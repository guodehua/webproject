$(function() { 
	//下架商品
	function deletefun(){
		var gid = $('#gId').textbox('getText');
		$.ajax({
			url:"/webproject/searchGood.do",
			type:'post',
			data:"gid="+gid+"&type=delete",
			success:function(msg){
				if (msg>0) {
					alert("商品成功下架");
					$('#ide').dialog('clear');
				} else {
					alert("无法下架");
				}
			}
		});
	}
	//保存修改
	function savefun(){
		var gid = $('#gId').textbox('getText');
		var gSaleprice = $('#gSaleprice').textbox('getText');
		var gInprice = $('#gInprice').textbox('getText');
		$.ajax({
			url:"/webproject/searchGood.do",
			type:'post',
			data:"gid="+gid+"&gInprice="+gInprice+"&gSaleprice="+gSaleprice+"&type=updatePrice",
			success:function(msg){
				if (msg>0) {
					alert("价格已修改");
				} else {
					alert("价格修改失败");
				}
			}
		});
	}
	$('#ide').dialog({
		toolbar:[{
			text:'保存修改',
			iconCls:'icon-save',
			handler:savefun
		},{
			text:'下架',
			iconCls:'icon-delete',
			handler:deletefun
		}]
	})
	$('#cc').combobox({ 
		'width':300,
		'hasDownArrow':false ,
		'showPanel':true,
		icons: [{
			iconCls:'icon-search',
			handler: function(){
				var serch = $('#cc').combobox('getText');
				$.ajax({
					   type: "POST",   //访问服务器的方式
					   url: "/webproject/searchGood.do",   //服务器（servlet）地址（get方式后可接参数）
					   data: "gtitle="+serch+"&type=search",   //传给服务器的参数（post）
					   // data 常用serialize()序列化，$("form").serialize() 
					   success: function(msg){           //接收服务器返回来的数据msg
						 var json = JSON.parse(msg);
						 $('#gId').textbox('setValue',json.gId);
						 $('#gId').textbox({'disabled':true});
						 $('#gTitle').textbox('setValue',json.gTitle);
						 $('#gTitle').textbox({'disabled':true});
						 $('#gAuthor').textbox('setValue',json.gAuthor);
						 $('#gAuthor').textbox({'disabled':true});
						 $('#gSaleprice').textbox('setValue',json.gSaleprice);
						 $('#gInprice').textbox('setValue',json.gInprice);
						 $('#cId').textbox('setValue',json.cId);
						 $('#cId').textbox({'disabled':true});
						 $('#pId').textbox('setValue',json.pId);
						 $('#pId').textbox({'disabled':true});
					     //alert(json);
					   }
					});
				$('#ide').dialog('open')
			}
		
		}]

	});
	
})