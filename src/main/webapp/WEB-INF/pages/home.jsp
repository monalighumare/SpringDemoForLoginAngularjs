<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<!-- <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script> -->
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular-resource.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/js/ngDialog.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/js/ngDialog.min.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/css/ngDialog.css">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/css/ngDialog.min.css">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/ng-dialog/1.4.0/css/ngDialog-theme-plain.css">
<link rel="stylesheet" href="http://bootstrapdocs.com/v3.1.1/docs/dist/css/bootstrap.min.css"/>

<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-animate.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular-sanitize.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.5.0.js"></script>
    <script src="/SpringDemoForLogin/resources/js/home.js"></script>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.selected {
    background-color:black;
    color:white;
    font-weight:bold;
}
</style>
</head>
<body ng-app="myapp" ng-controller="myappcontroller as $ctrl">

<script type="text/ng-template" id="myModalContent.html">
        <div class="modal-header">
            <h3 class="modal-title" id="title1">I'm a modal!</h3>
        </div>
        <div class="modal-body" id="body1">
            Are you sure you want to delete record
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="$ctrl.ok()">OK</button>
            <button class="btn btn-warning" type="button" ng-click="$ctrl.cancel()">Cancel</button>
        </div>


     </script> 
    
    <script type="text/ng-template" id="myModalUpdateContent.html">
        <div class="modal-header">
            <h3 class="modal-title" id="title2">I'm a modal!</h3>
        </div>
        <div class="modal-body" id="body2">
            Are you sure you want to Update record
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" type="button" ng-click="$ctrl.update()">Update</button>
            <button class="btn btn-warning" type="button" ng-click="$ctrl.cancelUpdate()">Cancel</button>
        </div>


     </script> 
     
	<h3>User Registration Form</h3>
	<form ng-submit="processUserDetails()">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">
				<tr>
					<td>ID</td>
					<td><input type="text" id="id" ng-model="userform.id"
						size="30" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" id="name" ng-model="userform.name"
						size="30" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" id="address"
						ng-model="userform.address" size="30" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						class="btn btn-primary btn-sm" ng-click="processUser()"
						value="Create / Update User" /></td>
				</tr>
			</table>
		</div>
	</form>
	<h3>Registered Users</h3>
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 600px">
			<tr>
				<th style=""  >Sr. No.</th>
				<th>Name</th>
				<th>Address</th>
				<th>Actions</th>
			
			</tr>

			<tr ng-repeat="employee in listEmployees" ng-class="{'selected':$index == selectedRow}" ng-click="setClickedRow($index)">
				<td style=""  >{{$index + 1}}</td>
				<td>{{ employee.name}}</td>
				<td>{{ employee.address }}</td>
				<td><button ng-click="$ctrl.openUpdate()" class="btn btn-primary btn-sm">Edit</button>
					| <button   ng-click="$ctrl.open()" class="btn btn-danger btn-sm">Delete</button></td>
<!-- 					ng-click="deleteUser(employee)" -->
			</tr>
		</table>
	</div>
	
	
	
	 
			  
</body>
<script type="text/javascript">
	
</script>

</html>