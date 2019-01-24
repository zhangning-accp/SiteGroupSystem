
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">

	<head>
		<meta charset="utf-8">
		<title>CreateRules</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/docs.css" />
		<link rel="apple-touch-icon-precomposed" href="./images/apple-touch-icon-precomposed.png" />
		<script type="text/javascript" src="js/zDrag.js"></script>
		<script type="text/javascript" src="js/zDialog.js"></script>
		<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
		<link rel="stylesheet" href="css/colorbox.css" />

		<script src="js/jquery.colorbox.js"></script>
		<style>
			.inline:link,
			.inline:visited {
				text-decoration: none;
				border-bottom: 1px solid #416CE5;
			}
		</style>

		<style type="text/css">
			.box {
				min-width: 250px;
				min-height: 200px;
				cursor: move;
				position: absolute;
				top: 10px;
				left: 10px;
				background-color: #FFF;
				border: 1px solid #CCCCCC;
				-webkit-box-shadow: 10px 10px 25px #ccc;
				-moz-box-shadow: 10px 10px 25px #ccc;
				box-shadow: 10px 10px 25px #ccc;
				margin: 0;
				padding-left: 10px;
				padding-bottom: 20px;
				overflow: hidden;
			}
			
			.coor {
				width: 10px;
				height: 10px;
				overflow: hidden;
				cursor: se-resize;
				position: absolute;
				right: 0;
				bottom: 0;
				background-color: #09C;
			}
			
			body {
				background-color: #FFFFFF;
			}
			
			#new_file {
				min-height: 250px;
			}
			
			.list {
				min-height: 250px;
			}
			
			#jstree1 ul {
				width: 100%;
				min-height: 150px;
				padding: 0;
			}
			
			#jstree1 ul li {
				width: 100%;
				height: 30px;
				font: 14px Verdana, sans-serif;
				list-style: none;
				text-align: center;
			}
			
			#jstree1 ul li p a {
				color: #666;
				text-decoration: none;
			}
			
			.lefts {
				float: left;
			}
			
			.rights {
				min-height: 600px;
				background-color: #FFFFFF;
				box-shadow: 0 0 3px #ADADAD;
				float: left;
				margin-top: 10px;
			}
		</style>
	</head>

	<body>
		<div class="container" id="content">

			<div class="col-md-3 col-lg-3 col-sm-3 lefts">
				<div id="jstree1">
					<ul style="margin-top: 30px;">

						<li>
							<p>
								<a href="#inline_content" id="jstree01" class="demo" style="margin-top:2em;" </a>
							</p>
						</li>
						<script>
							$(function() {
								$('#jstree01').jstree({

									'core': {
										'data': [{
											"text": "文件夹",
											"state": {
												"opened": true
											},
											"children": [{
													"text": "创建"
												}

											]
										}]
									}
								});
							});
						</script>
					</ul>

				</div>

				<script>
					$(document).ready(function() {
						$("#entr").hide();
					});

					function add(type) {
						if(type == "detail_group") {
							if($("#list1_center").length == 0) {
								$("#list1").append("<div class='box' id='list1_center'><div class='coor' id='list1_coor'></div></div>");
								drag("#list1_center", "#list1_coor", 410, 0);
								$("#list1_center").append($("#jstree3"));

							}

						} else if(type == "category") {
							if($("#list2_center").length == 0) {
								$("#list2").append("<div class='box' id='list2_center'><div class='coor' id='list2_coor'></div></div>");
								drag("#list2_center", "#list2_coor", 690, 0);
								$("#list2_center").append($("#jstree7"));

							}
						} else if(type == "size") {
							if($("#list4_center").length == 0) {
								$("#list4").append("<div class='box' id='list4_center'><div class='coor' id='list4_coor'></div></div>");
								drag("#list4_center", "#list4_coor", 970, 0);
								$("#list4_center").append($("#jstree5"));

							}

						} else if(type == "style") {

							if($("#list5_center").length == 0) {
								$("#list5").append("<div class='box' id='list5_center'><div class='coor' id='list5_coor'></div></div>");
								drag("#list5_center", "#list5_coor");
								$("#list5_center").append($("#jstree6"));

							}
						} else if(type = "color") {
							if($("#list3_center").length == 0) {
								$("#list3").append("<div class='box' id='list3_center'><div class='coor' id='list3_coor'></div></div>");
								drag("#list3_center", "#list3_coor", 690, 250);
								$("#list3_center").append($("#jstree4"));

							}
						} else {
							console.info("出现问题");
						}

					}
				</script>
				<script>
					function submit1()

					{
						$("#jstree1").append($("#ul2"));

					}

					function jstree3()

					{
						$("#jstree1").append($("#ul3"));
					}
				</script>

			</div>
			<div class="col-md-9 col-sm-9 col-lg-9 rights">
				<div class="col-lg-4 col-sm-4 col-md-4 list" id="list1">

				</div>
				<div class="col-lg-4 col-sm-4 col-md-4 list" id="list2">

				</div>

				<div class="col-lg-4 col-sm-4 col-md-4 list" id="list4">

				</div>
				<div class="col-lg-4 col-sm-4 col-md-4 list" id="list5">

				</div>
				<div class="col-lg-4 col-sm-4 col-md-4 list" id="list3">

				</div>
			</div>
			<div id="entr">

				<ul id="ul2">
					<li>
						<p>
							<a onClick="add('detail_group')">Details group</a>
						</p>
					</li>
				</ul>
				<ul id="ul3">
					<li>
						<p>
							<a onClick="add('category')">分类</a>
						</p>
					</li>
					<li>
						<p>
							<a onClick="add('size')">尺寸</a>
						</p>
					</li>
					<li>
						<p>
							<a onClick="add('style')">款式</a>
						</p>
					</li>
					<li>
						<p>
							<a onClick="add('color')">颜色</a>
						</p>
					</li>

				</ul>

				<div onClick="jstree3()" id="jstree3" class="demo" style="margin-top:2em;"></div>
				<div id="jstree7" class="demo" style="margin-top:2em;"></div>
				<div id="jstree5" class="demo" style="margin-top:2em;"></div>
				<div id="jstree6" class="demo" style="margin-top:2em;"></div>
				<div id="jstree4" class="demo" style="margin-top:2em;"></div>
				<script>
					var jstree7Data = [{
						"text": "分类",
						"state": {
							"opened": true
						},
						"children": [{
							"text": "分类一",
							"children": [{
								"text": "子分类一",
								"children": [{
									"text": "子分类三",
								}]
							}, {
								"text": "子分类二",
								"children": [{
									"text": "子分类三",
								}, {
									"text": "子分类四",
								}]
							}]
						}]
					}];
					var jstree3Data = [{
						"text": "Details group",
						"state": {
							"opened": true
						},
						"children": [{
								"text": "F1"
							},
							{
								"text": "F2"
							},
							{
								"text": "F3"
							},
							{
								"text": "F4"
							}
						]
					}, ];
					var jstree4Data = [{
						"text": "颜色",
						"state": {
							"opened": true
						},
						"children": [{
								"text": "Red"
							},
							{
								"text": "Green"
							},
							{
								"text": "Black"
							},
							{
								"text": "Blue"
							}
						]
					}, ];
					var jstree5Data = [{
						"text": "尺寸",
						"state": {
							"opened": true
						},
						"children": [{
								"text": "S"
							},
							{
								"text": "SM"
							},
							{
								"text": "L"
							},
							{
								"text": "XX"
							}
						]
					}, ];
					var jstree6Data = [{
						"text": "款式",
						"state": {
							"opened": true
						},
						"children": [{
								"text": "款式1"
							},
							{
								"text": "款式2"
							},
							{
								"text": "款式3"
							},
							{
								"text": "款式4"
							}
						]
					}, ];
					$(function() {
						jstreeCreate("#jstree3", jstree3Data);
						jstreeCreate("#jstree4", jstree4Data);
						jstreeCreate("#jstree5", jstree5Data);
						jstreeCreate("#jstree6", jstree6Data);
						jstreeCreate("#jstree7", jstree7Data);
					});

					function jstreeCreate(className, CoreData) {
						$(className).jstree({
							'plugins': ["wholerow", "checkbox"],
							'core': {
								"data": CoreData
							}
						});
					}
				</script>
			</div>
			<div id='inline_all'>
				<script>
					$("#inline_all").hide();
				</script>
				<div id='inline_content' style=' padding:10px;'>
					<form action="#" style="text-align: center;">
						<div class="form-group">
							<input type="text" class="form-control" id="exampleInputName1" placeholder="请输入文件名称">
						</div>
						<button style="width: 120px;" onClick="submit1()" type="submit" class="btn btn-info">提交</button>
					</form>

				</div>

			</div>

			<script>
				$("#jstree01").colorbox({
					inline: true,
					width: "30%",
				});
			</script>
			<script>
				function drag(divClassName, coorClassName, defulat_x, defulat_y) {
					$(document).mousemove(function(e) {
						if(!!this.move) {
							var posix = !document.move_target ? {
									'x': 0,
									'y': 0
								} : document.move_target.posix,
								callback = document.call_down || function() {
									$(this.move_target).css({
										'top': e.pageY - posix.y,
										'left': e.pageX - posix.x
									});
								};
							callback.call(this, e, posix);
						}
					}).mouseup(function(e) {
						if(!!this.move) {
							var callback = document.call_up || function() {};
							callback.call(this, e);
							$.extend(this, {
								'move': false,
								'move_target': null,
								'call_down': false,
								'call_up': false
							});
						}
					});
					var $box = $(divClassName).mousedown(function(e) {
						var offset = $(this).offset();
						this.posix = {
							'x': e.pageX - offset.left + defulat_x,
							'y': e.pageY - offset.top + defulat_y
						};
						$.extend(document, {
							'move': true,
							'move_target': this
						});
					}).on('mousedown', coorClassName, function(e) {
						var posix = {
							'w': $box.width(),
							'h': $box.height(),
							'x': e.pageX,
							'y': e.pageY
						};
						$.extend(document, {
							'move': true,
							'call_down': function(e) {
								$box.css({
									'width': Math.max(30, e.pageX - posix.x + posix.w),
									'height': Math.max(30, e.pageY - posix.y + posix.h)
								});
							}
						});
						return false;
					});
				}
			</script>
			<script src="./js/jquery.address-1.6.js"></script>
			<script src="./js/vakata.js"></script>
			<script src="./js/jstree.min.js"></script>
			<script src="./js/docs.js"></script>
			<script src="http://www.jq22.com/js/jq.js"></script>
	</body>

</html>