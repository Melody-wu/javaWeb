/**
 * Created by wml on 17/4/13.
 */
'use strict';
app.service('storage',['$rootScope',function($rootScope){
	return {
		setItem:function(a,b){
			var str=JSON.stringify(b);
			localStorage.setItem(a,str);
		},
		getItem:function(a){
			var json=localStorage.getItem(a);
			var obj=JSON.parse(json);
			return obj;
		}
	}
}]);