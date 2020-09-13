<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>已出发</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 车辆管理 <span class="c-gray en">&gt;</span> 已出发的车辆 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
		<div class="text-c">
			<span class="select-box inline">
				出发地：
		<select name="" class="select">
			<option value="1">郑州</option>
			<option value="2">上海</option>
		</select>
					--目的地：
		<select name="" class="select">
			<option value="1">北京</option>
			<option value="2">南京</option>
		</select>
		</span> 日期范围：
			<input type="text" name="" id="" placeholder="车牌号" style="width:250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <a class="btn btn-primary radius" data-title="车辆到达" data-href="order-add.html" onClick="article_stop(this,'10001')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 车辆到达</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th>编号</th>
					<th width="80">车牌号</th>
					<th width="80">出发地</th>
					<th width="120">目的地</th>
					<th width="75">时间</th>
					<th width="60">状态</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="car">
				<tr class="text-c">
					<td><input type="checkbox" value="" name=""></td>
					<td>${car.cid}</td>
					<td>${car.carnum}</td>
					<td>${car.fromStore.sname}</td>
					<td>${car.toStore.sname}</td>
					<td><fmt:formatDate value="${car.createtime}" pattern="yyyy-MM-dd" /></td>
					<td>运输中</td>
					<td class="f-14 td-manage">
						<a style="text-decoration:none" onClick="article_stop(this,'${car.cid}')" href="javascript:;" title="车辆到达"><i class="Hui-iconfont">&#xe6de;车辆到达</i></a></td>
				</tr>
			</c:forEach>
			</tbody>

		</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">


	function article_stop(obj,id){
		$.post("/car/updateTravel",{"cid":id},function (response) {
			if(response=="true"){
				layer.msg('车辆已经到达!',{icon:1,time:2000});
				$(obj).parents("tr").remove();
			}else{
				layer.msg('车辆到达失败!',{icon:2,time:2000});
			}
		},"text");
	}



</script> 
</body>
</html>