var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
  $scope.submitForm = function(){
	alert("Sent Successfully");
    var url = $location.absUrl() + "/api/v1/sms";
    
    var config = {
                headers : {
                    'Accept': 'application/json'
                }
        }
    var data = {
    		phoneNumber: $scope.phoneNumber,
    		message: $scope.message
        };
    
    $http.post(url, data, config).then(function (response) {
      $scope.postResultMessage = response.data;
    }, function error(response) {
      $scope.postResultMessage = "Error with status: " +  response.statusText;
    });
    
    $scope.phoneNumber = "";
    $scope.message = "";
  }
});
