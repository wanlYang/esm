layui.use(['form', 'layer','flow', 'jquery', "element",'carousel','table'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element,
        $ = layui.jquery,
        carousel = layui.carousel,
        flow = layui.flow,
		table = layui.table;
	//文章列表
	var tableIns = table.render({
		elem: '#shopCart',
		url: getRealPath() + '/shopcart/list/table',
		method:"post",
		id: "shopCartList",
		toolbar: "#toolbar",
		cols: [
			[{
				type: "checkbox",
				fixed: "left",
				width: 50,
			},
				{
					field: 'img',
					title: '商品图片',
					event: 'preview',
					align: "center",
					style: 'cursor: pointer;',
					templet:function(d){
						return "<img height='100%' src='/"+d.product.img+"' class='cover'/>";
					}
				},
				{
					field: 'mainTitle',
					title: '商品名称',
					templet:function(d){
						return "<a href='/product/"+d.product.id+"'>"+d.product.mainTitle+"</a>";
					}
				},
				{
					field: 'price',
					title: '单价',
					align: 'center',
					templet:function(d){
						return "￥"+d.product.price;
					}
				},
				{
					field: 'amount',
					title: '数量',
					align: 'center',
					edit: 'text',
					templet:function(d){
						return d.amount;
					}
				},
				{
					field: 'subTotal',
					title: '小计',
					align: 'center',
					templet:function(d){
						return "￥" + (d.amount * d.product.price).toFixed(2);
					},
				},
				{
					title: '操作',
					width: 170,
					templet: '#shopCartListBar',
					fixed: "right",
					align: "center"
				}
			]
		],
		text: {
			none: '暂无相关数据' // 默认：无数据。注：该属性为 layui 2.2.5 开始新增
		},
		response: {
			statusName: 'status', // 规定数据状态的字段名称，默认：code
			statusCode: 200, // 规定成功的状态码，默认：0
			msgName: 'message', // 规定状态信息的字段名称，默认：msg
			countName: 'count', // 规定数据总数的字段名称，默认：count
			dataName: 'data' // 规定数据列表的字段名称，默认：data
		}
	});
	//头工具栏事件
	table.on('toolbar(shopCart)', function(obj){
		var checkStatus = table.checkStatus(obj.config.id);
		switch(obj.event){
			case 'getCheckData':
				var data = checkStatus.data;
				if (data.length == 0){
					layer.msg("请选择商品!");
					return;
				}
				//layer.alert(JSON.stringify(data));
				break;
			case 'clearShopCart':
				var data = checkStatus.data;

				break;
		};
	});

	//监听行工具事件
	table.on('tool(shopCart)', function(obj){
		var data = obj.data;
		//console.log(obj)
		if(obj.event === 'del'){
			layer.confirm('真的删除行么', function(index){
				obj.del();
				layer.close(index);
			});
		} else if(obj.event === 'preview'){
			preview_img("/"+obj.data.product.img);
		}
	});
	table.on('edit(shopCart)', function(obj){
		console.log(obj.value); //得到修改后的值
		console.log(obj.field); //当前编辑的字段名
		console.log(obj.data); //所在行的所有相关数据
		var reg=/(^[1-9]{1,2}$)/;
		if (!reg.test(obj.value)){
			layer.msg("请输入1~99之间的数值!");
			obj.update({

			});

		}


	});
	function preview_img(url) {
		var img = new Image();
		img.src = url;
		var height = img.height + 42; //获取图片高度
		var width = img.width; //获取图片宽度
		var imgHtml = "<img src='" + url + "' />";
		//弹出层
		layer.open({
			type: 1,
			shade: 0.8,
			offset: 'auto',
			area: [width + 'px',height+'px'],
			shadeClose:true,//点击外围关闭弹窗
			scrollbar: false,//不现实滚动条
			title: "图片预览", //不显示标题
			content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响

		});
	}


})


