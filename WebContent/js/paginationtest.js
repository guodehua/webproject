$(function() {
	$('#pagination').pagination({
	  pageSize: 5,
	  firstBtnText:'首页',
	  lastBtnText:'尾页',
	  prevBtnText:'上一页', 
	  nextBtnText:'下一页',
	  //showInfo:true,
	  noInfoText:'没有数据',
	  //showJump:true,
	  //showPageSizes:true,
	  remote:{
		  	url:'/webproject/ajax.do',
		  	totalName:'totalnumber',
		  	//pageIndexName: 'pageindex',  
		    //pageSizeName: 'pagesize', 
		  	success:function(pageinfo){
		  		$('#context').empty();
		  		var ul="<ul>";
		  		$(pageinfo.data).each(function(index,goods){
		  			ul+="<li>" + goods.gTitle+"</li>";
		  		}) 
		  		ul+="</ul>";
		  		$('#context').append(ul);
		  	}
	  }
	});
})
