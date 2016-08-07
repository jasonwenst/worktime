var app = angular.module('app', [ 'restangular', 'darthwade.dwLoading']);
 
    app.controller('workController', ['$scope', 'BusinessService', '$loading',  function ($scope, BusinessService, $loading) {
    	
        $scope.currentPage = 0;
        $scope.pageCount = 0;
        $scope.allEmps = {}
        $scope.currentData = {}
        $scope.allStates = {}
        $scope.allProcs = {}
        $scope.allProcTypes = {}
        $scope.updateData = {}
        $scope.searchProcTypes = {}
        $scope.searchProcs = {}
        $scope.searchCriteria = {}
        $scope.pageSize = 10;
        var postData = {
        		pageIndex: 0,
        		pageSize: $scope.pageSize
        }
        
//        var initPage = function() {
//            $loading.start("loadingPage");
//            GetAllWorkTime(postData);
//            getAllEmps();
//            getAllStates();
//            getAllProcs();
//            getAllProcTypes();
//            $loading.finish("loadingPage");
//        }
        
 
        var GetAllWorkTime = function (postData) {
            BusinessService.list(postData).then(function (response) {
            	console.log("response = " + response);
                $scope.workTimes = response.content;
                $scope.currentPage = response.number;
                $scope.pageCount = response.totalPages;
                refrushBtn(response.number, response.totalPages - 1);
                $loading.finish('loadingPage');
                $loading.finish("loadingChange");
            });
        }
        
        var getAllEmps = function() {
        	BusinessService.getAllEmps().then(function(response) {
        		console.log("getAllEmps processed!");
        		
        		var emtpyEmp = [{
        			empId : -1,
        			empName : "请选择"
        		}]
        		
        		for(var i = 0; i < response.length; i++) {
        			emtpyEmp.push(response[i]);
        		}
        		
        		$scope.allEmps = emtpyEmp;
        	})
        }
 
        var getAllStates = function() {
        	BusinessService.getAllStates().then(function(response) {
        		console.log("getAllStates processed!");
        		$scope.allStates = response;
        	})
        }
        
        var getAllProcs = function() {
        	BusinessService.getAllProc().then(function(response) {
        		console.log("getAllProc processed!");
        		$scope.allProcs = response;
        	})
        }
        
        var getAllProcTypes = function() {
        	BusinessService.getAllProcTypes().then(function(response) {
        		console.log("getAllProcTypes processed!");
        		$scope.allProcTypes = response;
        		var emptyProcType = [{
        			procType : -1,
        			procName : "请选择"
        		}]
        		for(var i = 0; i < response.length; i++) {
        			emptyProcType.push(response[i]);
        		}
        		$scope.searchProcTypes = emptyProcType;
        	})
        }
        
        var getAllProcByProcType = function(procType) {
        	BusinessService.getAllProcByProcType(procType).then(function(response) {
        		console.log("getAllProcByProcType processed!");
        		$scope.allProcs = response;
        		$scope.searchProcs = response;
        	})
        }
        
        var deleteWork = function(work) {
        	$loading.start('loadingChange');
        	BusinessService.deleteWorkItem(work).then(function(response) {
        		console.log("deleteWorkItem processed!");
        		GetAllWorkTime(postData);
        	})
        }
        
        $scope.nextPage = function() {
        	$loading.start("loadingChange");
        	pData = {
                    pageIndex: ($scope.currentPage + 1),
                    pageSize: $scope.pageSize
                }
        	console.log("pData = " + pData.pageIndex);
        	
        	GetAllWorkTime(pData);
        	
        	
        }
 
        
        $scope.prePage = function(currentPage, pageCount) {
        	$loading.start("loadingChange");
        	pData = {
                    pageIndex: ($scope.currentPage - 1),
                    pageSize: $scope.pageSize
                }
        	console.log("pData = " + pData.pageIndex);
        	GetAllWorkTime(pData);
        	
        }
        
        $scope.resetSearch = function() {
        	resetSearch();
        }
        
        var resetSearch = function () {
        	$scope.searchCriteria = {
            		criteria : {
            			tbProc : {
                			procId : -1,
                			tbRpocType : {
                				procType : -1
                			}
                		},
                		requestCode : -1,
                		requestName : "",
                		dev : {
                			empId : -1
                		},
                		qa : {
                			empId : -1
                		}
            		},
            		currentPage : $scope.currentPage,
            		pageSize : $scope.pageSize
            }
        }
        
        function refrushBtn(cPage, pCount) {
        	$scope.preDisabled = false;
        	$scope.nextDisabled = false;
        	if(pCount <= 0) {
        		$scope.preDisabled = true;
        		$scope.nextDisabled = true;
        		return;
        	}
        	if(cPage == 0) {
        		$scope.preDisabled = true;
        	}
        	
        	if(cPage == pCount) {
        		$scope.nextDisabled = true;
        	}	
        	
        }
        
        
        
        $scope.update = function(work) {
        	$loading.start("loadingChange");
        	BusinessService.update(work);
        	GetAllWorkTime(postData);
        	$scope.$apply();
        }
        


        $scope.dataTrans = function(data) {
        	$scope.currentData = data;
        }
        
        $scope.openAddDialog = function() {
        	$scope.currentData = {}
        }
        
        $scope.deleteWork = function(work) {
        	deleteWork(work);
        	GetAllWorkTime(postData);
        	
        }
        
        $scope.filterProcs = function() {
        	getAllProcByProcType($scope.currentData.tbProc.tbRpocType.procType);
        }
        
        $scope.filterSearchProcs = function(procType) {
        	BusinessService.getAllProcByProcType(procType).then(function(response) {
        		console.log("getAllProcByProcType processed!");
        		var emptyProc = [{
        				procId : -1,
        				procName : "请选择",
        				tbRpocType :{
        					procType : "-1",
        					procName : "请选择"
        				}
        		}]
        		for(var i = 0; i < response.length;i++) {
        			emptyProc.push(response[i]);
        		}
        		$scope.searchProcs = emptyProc;
        		
        	})
        }
        
        $scope.cancle = function() {
        	console.log("cancle processed");
        }
        

        
        $scope.search = function() {
        	$loading.start('loadingChange');
        	BusinessService.getPagingWithConditon($scope.searchCriteria).then(function(response) {
        		console.log("response = " + response);
                $scope.workTimes = response.content;
                $scope.currentPage = response.number;
                $scope.pageCount = response.totalPages;
                refrushBtn(response.number, response.totalPages - 1);
                $loading.finish('loadingPage');
                $loading.finish("loadingChange");
        	}) 
        }

//        initPage();
        GetAllWorkTime(postData);
        getAllEmps();
        getAllStates();
        getAllProcs();
        getAllProcTypes();
        resetSearch();
//        $loading.start("loadingChange");
//        $loading.finish("loadingChange");
        
    }]);
 
 
    app.factory('BusinessService', ['Restangular', function (Restangular) {
    	var url = Restangular.all('/worktime/workTimes');
        var list = function (postData) {
            return url.post(postData);
        }
 
        return {
            list: function (postData) {
                return url.post(postData);
            },
            update : function(postData) {
            	return Restangular.all('/worktime/workTime/update').post(postData);
            },
            getAllEmps : function() {
            	return Restangular.all('/worktime/emps').getList();
            },
            getAllStates : function() {
            	return Restangular.all('/worktime/states').getList();
            },
            getAllProc : function() {
            	return Restangular.all('/worktime/procs').getList(); 
            },
            getAllProcTypes : function() {
            	return Restangular.all('/worktime/procTypes').getList();
            },
            getAllProcByProcType : function(procType) {
            	return Restangular.one('/worktime/procs/proctype/'+ procType).get();
            },
            deleteWorkItem : function(work) {
            	return Restangular.all('/worktime/worktime/delete').post(work);
            },
            getPagingWithConditon : function(criteria) {
            	return Restangular.all('/worktime/workTimes/pages').post(criteria);
            }
            
            
        }
    }]);
    
//    app.controller('dialogController', ['$scope', '$model', function($scope, $model) {
//    	$scope.openDialog = function() {
//    		$model.open({
//    			templateUrl : 'dialog.html',
//    			controller : dialogController,
//    			resolve : {currentWork : function() {return $scope.data}}
//    		})
//    	}
//    }])