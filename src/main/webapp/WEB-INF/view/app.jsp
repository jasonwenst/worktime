<!DOCTYPE html >
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<head>
<title></title>

<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	
	<link rel="stylesheet" src="static/css/table.css">
	<link rel="stylesheet" src="static/css/angular-loading.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="static/js/framework/angular-1.5.8.min.js"></script>
<script type="text/javascript"
	src="static/js/framework/angular-ui-router.js"></script>

<script type="text/javascript" src="static/js/framework/restangular.js"></script>
<script type="text/javascript" src="static/js/framework/angular-loading.js"></script>
<script type="text/javascript" src="static/js/framework/spin.1.2.7.js"></script>


<script type="text/javascript"
	src="static/js/framework/login-scripts.js"></script>
<script type="text/javascript"
	src="static/js/framework/lodash/lodash.min.js"></script>

<script type="text/javascript" src="static/js/app.js" charset="UTF-8"></script>

</head>
<body ng-app="app">
	<div ng-controller="workController">
	
	<form class="form-inline">
	  <div class="form-group">
	    <label for="searchProcType">项目分类</label>
	    <select class="form-control" id="searchProcType"  ng-model="searchCriteria.criteria.tbProc.tbRpocType.procType" ng-change="filterSearchProcs(searchCriteria.criteria.tbProc.tbRpocType.procType)"  ng-options="procType.procType as procType.procName for procType in searchProcTypes"></select>
	  </div>
	  <div class="form-group">
	    <label for="exampleInputEmail2">具体来源</label>
	    <select class="form-control"  ng-model="searchCriteria.criteria.tbProc.procId"   ng-options="proc.procId as proc.procName for proc in searchProcs "></select>
	  </div>
  	  <div class="form-group">
	    <label for="exampleInputEmail2">开发人员</label>
	    <select class="form-control"  ng-model="searchCriteria.criteria.dev.empId"   ng-options="emp.empId as emp.empName for emp in allEmps"></select>
	  </div>
  	  <div class="form-group">
	    <label for="exampleInputEmail2">测试人员</label>
	    <select class="form-control"  ng-model="searchCriteria.criteria.qa.empId"   ng-options="emp.empId as emp.empName for emp in allEmps"></select>
	  </div>
	  <button type="submit" class="btn btn-default" ng-click="search()">查询</button>
	  <button class="btn btn-default" ng-click="resetSearch()">重置</button>
	</form>
	
		<div class="box small" dw-loading="loadingChange" dw-loading-options="{text:'',overlay: true, spinnerOptions:{position:'absolute', top:200, left:'auto'}}"></div>
		<div class="box small" dw-loading="loadingPage" dw-loading-options="{ active: true,text:'',top:100,overlay: true,position: 'relative'}">
		<table class="table table-hover  table-striped">
<!-- <table> -->
			<thead>
				<tr class = "thfront info">
<!-- 					<td class="thfront">项目分类</td> -->
<!-- 					<td>具体来源</td> -->
<!-- 					<td>需求编号</td> -->
<!-- 					<td>需求名</td> -->
<!-- 					<td>开发人员</td> -->
<!-- 					<td>测试人员</td> -->
<!-- 					<td>实际开发工时</td> -->
<!-- 					<td>实际测试工时</td> -->
<!-- 					<td>实际总工时</td> -->
<!-- 					<td>是否已申报工时</td> -->
<!-- 					<td>申报开发工时</td> -->
<!-- 					<td>申报测试工时</td> -->
<!-- 					<td>申报总工时</td> -->
<!-- 					<td>创建时间</td> -->
<!-- 					<td>操作</td> -->

					<th class="thfront">项目分类</th>
					<th>具体来源</th>
					<th>需求编号</th>
					<th>需求名</th>
					<th>开发人员</th>
					<th>测试人员</th>
					<th>实际开发工时</th>
					<th>实际测试工时</th>
					<th>实际总工时</th>
					<th>是否已申报工时</th>
					<th>申报开发工时</th>
					<th>申报测试工时</th>
					<th>申报总工时</th>
					<th>创建时间</th>
					<th>操作</th>

				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="work in workTimes">
					<td>{{work.tbProc.tbRpocType.procName}}</td>
					<td>{{work.tbProc.procName}}</td>
					<td>{{work.requestCode}}</td>
					<td>{{work.requestName}}</td>
					<td>{{work.dev.empName}}</td>
					<td>{{work.qa.empName}}</td>
					<td>{{work.realDevHour}}</td>
					<td>{{work.realQaHour}}</td>
					<td>{{work.realWholeHour}}</td>
					<td>{{work.tbWorkState.workStateName}}</td>
					<td>{{work.applyDevHour}}</td>
					<td>{{work.applyQaHour}}</td>
					<td>{{work.applyWholeHour}}</td>
					<td>{{work.createTime | date:'yyyy-MM-dd' }}</td>
					<td>
						<button data-toggle="modal" data-target="#myModal" class="btn btn-success col-md-6" data-whatever="work" ng-click="dataTrans(work)">修改</button>
						<button type="button" ng-click="dataTrans(work)"  class="btn btn-danger col-md-6" data-toggle="modal" data-target=".bs-example-modal-sm">删除</button>	
					</td>
				</tr>
			</tbody>
		</table>
		</div>
		
		<div>
			<input type="button" class="btn btn-primary"
				ng-disabled="preDisabled" value="上一页" ng-click="prePage()"></input>
			<input type="button" class="btn btn-primary"
				ng-disabled="nextDisabled" value="下一页" ng-click="nextPage('LoadingChange')"></input>
			<span>第{{currentPage+1}}页 共 {{pageCount}}页</span>
			<button data-toggle="modal" data-target="#myModal"
							class="btn btn-success right" data-whatever="work"
							ng-click="openAddDialog()">新增</button>
		</div>
		
		<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		      <input type = "button" class="btn" data-dismiss="modal" value="取消"></input>
		      <input type = "button" ng-click="deleteWork(currentData)" data-dismiss="modal" class="btn btn-danger" value="确定"></input>
		    </div>
		  </div>
		</div>
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
<!-- 						<h4 class="modal-title" id="myModalLabel">Modal title</h4> -->
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="corp" class="col-sm-3 control-label">项目分类</label>
								<div class="col-sm-9">
									<select class="form-control"  ng-model="currentData.tbProc.tbRpocType.procType" ng-change="filterProcs()"  ng-options="procType.procType as procType.procName for procType in allProcTypes"></select>
								</div>
							</div>
							<div class="form-group">
								<label for="corp" class="col-sm-3 control-label">需求来源</label>
								<div class="col-sm-9">
									<select class="form-control"  ng-model="currentData.tbProc.procId"   ng-options="proc.procId as proc.procName for proc in allProcs "></select>
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">需求编号</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.requestCode">
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">需求名</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.requestName">
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">开发人员</label>
								<div class="col-sm-9">
										<select class="form-control"  ng-model="currentData.dev.empId" ng-selected="currentData.dev" ng-options="emp.empId as emp.empName for emp in allEmps"></select>
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">测试人员</label>
								<div class="col-sm-9">
										<select class="form-control"  ng-model="currentData.qa.empId"  ng-options="emp.empId as emp.empName for emp in allEmps"></select>
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">实际开发工时</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.realDevHour">
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">实际测试工时</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.realQaHour">
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">实际总工时</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.realWholeHour">
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">是否已提交申报</label>
								<div class="col-sm-9">
										<select class="form-control"  ng-model="currentData.tbWorkState.workStateCode"  ng-options="state.workStateCode as state.workStateName for state in allStates"></select>
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">申报开发工时</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.applyDevHour">
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">申报测试工时</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.applyQaHour">
								</div>
							</div>
							<div class="form-group">
								<label for="requestCode" class="col-sm-3 control-label">申报总工时</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="requestCode"
										ng-model="currentData.applyWholeHour">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
        
						<button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancle()">取消</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="update(currentData)">保存</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>