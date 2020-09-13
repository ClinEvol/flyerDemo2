<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/lib/html5shiv.js"></script>
<script type="text/javascript" src="/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>柱状图统计</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 统计管理 <span class="c-gray en">&gt;</span> 柱状图统计 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div id="container" style="min-width:700px;height:400px"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
/
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/static/js/echarts-all.js"></script>
<script type="text/javascript">
$(function () {
    // 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('container'));
	var dataName = [];
	var dataCount = [];
	// 指定图表的配置项和数据
	var option2 = {
		title: {
			text: '订单量统计'
		},
		tooltip: {},
		legend: {
			data: ['订单量']
		},
		xAxis: {
			data: dataName,
		},
		yAxis: {
			type: 'value',
			name: '订单量',
			splitNumber: 5
		},
		series: [{
			itemStyle: {
				normal: {
					color: '#33CCFF',
					lineStyle: {
						color: '#33CCFF'
					}
				}
			},
			name: '订单量',
			type: 'bar',
			//柱状宽度
			barWidth: 20,
			data: dataCount,
		}]
	};
	//请求后台
	$.getJSON("/orderinfo/count",function (response) {
		$(response).each(function(){
			dataName.push(this.sname);
			dataCount.push(this.count);
		});
		myChart.setOption(option2);
	})
});				
</script>
</body>
</html>