
var app = angular.module('myapp',['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

	app.controller('myappcontroller', function($scope, $http ,$uibModal, $log, $document) {
		
		var $ctrl = this;
		  $ctrl.items = ['item1', 'item2', 'item3'];
			
// 		  angular.element('.modal').css('display', 'none');
		  
		  
		  $ctrl.animationsEnabled = true;

		  $ctrl.open = function (size, parentSelector) {
		    var parentElem = parentSelector ? 
		      angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
		    var modalInstance = $uibModal.open({
		      animation: $ctrl.animationsEnabled,
		      ariaLabelledBy: 'title1',
		      ariaDescribedBy: 'body1',
		      templateUrl: 'myModalContent.html',
		      controller: 'ModalInstanceCtrl',
		      controllerAs: '$ctrl',
		      size: size,
		      appendTo: parentElem,
		      resolve: {
		        items: function () {
		          return $ctrl.items;
		        }
		      }
		    });

 		    modalInstance.result.then(function (selectedItem) {
 		    	
 		      $ctrl.selected = selectedItem;
 		    }, function () {
 		      $log.info('Modal dismissed at: ' + new Date());
 		    });
		  };
		  
		  $ctrl.openUpdate = function (size, parentSelector) {
			    var parentElem = parentSelector ? 
			      angular.element($document[0].querySelector('.modal-demo ' + parentSelector)) : undefined;
			    var modalInstance = $uibModal.open({
			      animation: $ctrl.animationsEnabled,
			      ariaLabelledBy: 'title2',
			      ariaDescribedBy: 'body2',
			      templateUrl: 'myModalUpdateContent.html',
			      controller: 'ModalInstanceCtrlForUpdate',
			      controllerAs: '$ctrl',
			      size: size,
			      appendTo: parentElem,
			      resolve: {
			        items: function () {
			          return $ctrl.items;
			        }
			      }
			    });

 			    modalInstance.result.then(function (selectedItem) {
 			    	getEditUserDetails(employee);
 			      $ctrl.selected = selectedItem;
 			    }, function () {
 			      $log.info('Modal dismissed at: ' + new Date());
 			    });
			  };
		$scope.users = []
		$scope.userform = {
			name : "",
			department : ""
		};

		getUserDetails();
		document.getElementById("id").disabled = true;
		
		  $scope.selectedRow = null;  // initialize our variable to null
		  $scope.setClickedRow = function(index){  //function that sets the value of selectedRow to current index
		     $scope.selectedRow = index;
		  }
		  
		function getUserDetails() {
			
			$http({
				method : 'GET',
				url : 'http://localhost:8085/SpringDemoForLogin/emp/employee'
			}).then(function successCallback(response) {
				$scope.listEmployees = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}	
		
		function getEditUserDetails(employee) {
			$http({
				method : 'GET',
				url : 'http://localhost:8085/SpringDemoForLogin/emp/editEmployee',
				params : employee
			}).then(function successCallback(response) {
				$scope.empInfo = response.data;
				$scope.userform.id = $scope.empInfo.id;
				$scope.userform.name = $scope.empInfo.name;
				$scope.userform.address = $scope.empInfo.address;			

			}, function errorCallback(response) {
				console.log(response.statusText);
				
			});
		}	
		
		$scope.processUser = function() {
			$http({
				method : 'POST',
				url : 'http://localhost:8085/SpringDemoForLogin/emp/saveEmployee',
				data : angular.toJson($scope.userform),
				headers : {
					'Content-Type' : 'application/json'
				}			
			}).then(function successCallback(response) {
				
				clearForm();
				getUserDetails();
			});
		}
		
		
		$scope.editUser = function(employee) {
			//getUserDetails();			
			$http({
				method : 'GET',
				url : 'http://localhost:8085/SpringDemoForLogin/emp/editEmployee',
				params : employee
			}).then(function successCallback(response) {
				$scope.empInfo = response.data;
				$scope.userform.id = $scope.empInfo.id;
				$scope.userform.name = $scope.empInfo.name;
				$scope.userform.address = $scope.empInfo.address;			

			}, function errorCallback(response) {
				console.log(response.statusText);
				
			});
		}

	      
	    
		$scope.deleteUser = function(employee) {
			  $http({
					method : 'GET',
					url : 'http://localhost:8085/SpringDemoForLogin/emp/deleteEmployee',
					params : employee,
					headers : {
						'Content-Type' : 'application/json'
					}
				}).then(function successCallback(response) {				
					getUserDetails();
				});
	        
		}
		
	
			  
		function clearForm() {
			$scope.userform.id = "";
			$scope.userform.name = "";
			$scope.userform.address = "";
		};
		
		function disableName() {
// 			document.getElementById("name").disabled = true;
		}
	});
	
	angular.module('myapp').controller('ModalInstanceCtrl', function ($uibModalInstance, items) {
		  var $ctrl = this;
		  $ctrl.items = items;
		  $ctrl.selected = {
		    item: $ctrl.items[0]
		  };
		  $ctrl.ok = function () {
			    alert("You clicked the ok button."); 

		    $uibModalInstance.close($ctrl.selected.item);
		  };

		  $ctrl.cancel = function () {
		    $uibModalInstance.dismiss('cancel');
		  };
		});
	
	angular.module('myapp').controller('ModalInstanceCtrlForUpdate', function ($uibModalInstance, items) {
		  var $ctrl = this;
		  $ctrl.items = items;
		  $ctrl.selected = {
		    item: $ctrl.items[0]
		  };

			$ctrl.update = function () {
//				  getEditUserDetails();
			    $uibModalInstance.close($ctrl.selected.item);
			  };
			  
			  $ctrl.cancelUpdate = function () {
				    $uibModalInstance.dismiss('cancel');
				  };

		 
		});