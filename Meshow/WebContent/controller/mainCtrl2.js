'use strict';
angular.module('myApps')
  .run(['$document', '$templateCache', function($document, $templateCache) {
     var scripts = Array.prototype.slice.call($document[0].scripts, 0);
     scripts.forEach(function(script) {
       if (script.type === 'text/template') {
         $templateCache.put(script.id, script.innerHTML);
       }
     });
   }])
.controller('loginCtrl',['$scope','storage','$state',function($scope,storage,$state){
	 		$scope.userLogin = {
               	name:'',
               	password:''
            };
            $scope.disableLoginButton = false;
            $scope.getSuccess=function(){
            	var useInfo=$scope.searlize.$$success.parse;
            	var correctName=useInfo[0].$viewValue;
            	var correctPassword=useInfo[1].$viewValue;
            console.log('wwww')
        
            };
}])
.controller('appCtrl',['$rootScope','$state','storage','$scope',function($rootScope,$state,storage,$scope){
	//console.log('我进入了主界面');
      console.log(storage.isLogin())
      if(storage.isLogin()){
            console.log('true')
      }else{
            console.log('false')
      }
     
}])
.controller('desktopCtrl',['$scope','$state','$templateCache','$sce',function($scope,$state,$templateCache,$sce){
	console.log('我进入了桌面');
	$scope.gow=function(){
		   //Params.setParam('BalanceCtrl.balanceAmt',$scope.balance);
            $state.go('stage');
	};
	
	// $scope.text=$sce.trustAsHtml($templateCache.get('template/desktopBranch.html'));
	// $scope.content=$sce.trustAsHtml($templateCache.get('desktopContent'))
}])
.controller('stageCtrl',['$scope','storage','$state',function($scope,storage,$state){
      $scope.isStatus=0;
      $scope.changeStatus=function(){
             if($scope.isStatus==1){
                  $scope.isStatus=0;
                  return;
             }
             $scope.isStatus=1;
      };
       $scope.goContent=function(){
         $(window).scrollTop(1050)
      }
      $scope.goGames=function(){
         window.open('http://wumenglong.duapp.com/component/h5/rotate.html');
      }
}])
.controller('activeCtrl',['$scope',function($scope){
   $scope.getCode=function(){
      $scope.isOk=true;
   }  
}])
.controller('headerCtrl',['$scope',function($scope){
	console.log('头部文档固定');
}])
.controller('sidebarCtrl',['$scope',function($scope){
	console.log('侧面文档固定');
}])
.controller('sidebarRightCtrl',['$scope',function($scope){
	console.log('侧右边文档固定');
}])
.controller('backStageCtrl',['$scope',function($scope){
	console.log('侧右边文档固定');
}])
.controller('desktopCtrl',['$scope','$http',function($scope,$http){
	console.log("我进来了");
	$http({
		method:"GET",
		url:"backstage/desktop"
	}).then(function success(res){
		console.log(res)
	},function error(res){
		console.log(res)
	})
}])