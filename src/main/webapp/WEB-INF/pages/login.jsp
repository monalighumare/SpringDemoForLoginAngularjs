<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="http://bootstrapdocs.com/v3.1.1/docs/dist/css/bootstrap.min.css"/>
<body>

<div ng-app="loginapp" ng-controller="logincontroller">
 <form > 
  <div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">
				<tr>
					<td>ID</td>
					<td><input type="text" id="userName" ng-model="loginform.userName"
						size="30" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" id="password" ng-model="loginform.password"
						size="30" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit"
						class="btn btn-primary btn-sm"
						value="Login" ng-click="loginUser()"/></td>
				</tr>
			</table>
		</div>
		</form>
</div>

<script type="text/javascript">

var app = angular.module('loginapp',[]);

	app.controller('logincontroller', function($scope, $http ) {
				
		$scope.loginUser = function() {
			alert()
			$http({
				method : 'POST',
				url : 'http://localhost:8085/SpringDemoForLogin/loginPage',
				data : angular.toJson($scope.loginform),
				headers : {
					'Content-Type' : 'application/json'
				}			
			});
		}
		
		
		
	});
	

</script>
</body>
</html>