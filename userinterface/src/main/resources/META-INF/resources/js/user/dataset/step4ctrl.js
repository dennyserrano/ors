'use strict';

angular.module('UserApp')
    .controller('Step4Ctrl', ['$scope', '$window', '$state', '$timeout', 'UserDatasetService', 'PreviewDataService','localStorageService',
        function($scope, $window, $state, $timeout, UserDatasetService, PreviewDataService,localStorageService) {

            $scope.step1 = 'complete';
            $scope.step2 = 'complete';
            $scope.step3 = 'complete';
            $scope.step4 = 'active';
                        
            $scope.loadingData = 0;
            $scope.headers = [];
            $scope.datas = [];

            $window.ORS.AdjustDatasetContents(0);
            $scope.datasetJson1="haha";
            $scope.$watch('loadingData', function(newVal, oldVal) {
                if (oldVal === 0 && newVal === 1) {
                    $timeout(function() {
                        $window.ORS.FitToWidth($('#previewContainer'));
                        $window.scrollTo(0, 0);
                    }, 50);
                }
            });
            
            $scope.$on('render-done', function(event) {
                $timeout($window.ORS.AdjustPreviewTable, 50);
            });
            
            var previewDataCallback = function(returnData) {
            	
            	if(returnData.code==0)
        		{
            		var data=returnData.data;
            		$scope.loadingDataError="";
            		$scope.headers = data[0];
                    data.splice(0, 1); // removes the header
                    $scope.datas = angular.copy(data);
                    $scope.loadingData = 1;
        		}else
    			{
        			$scope.loadingDataError=returnData.message;
    			}
                
            };
           
          
        	UserDatasetService.get({}, function(dataset) {
        		
            	dataset=localStorageService.get('dataset');
            	
            	if(dataset==null)
        		{
        			$state.go("step1");
        		}
                $scope.dataset = dataset;
                $scope.datasetJson = angular.toJson(dataset);
                $scope.loadingDataError="";
                PreviewDataService.preview(dataset, previewDataCallback);
            }, function(response) {
                $scope.loadingData = 2;
                $scope.loadingDataError = 'Failed to load Preview of Data. [HTTP Status: ' + response.status + '].';
            });
    	
            

            $scope.keys = function(obj) {
                return obj ? Object.keys(obj) : [];
            };
            
            $scope.previous = function() {
                var dataset = $scope.dataset;
                UserDatasetService.save({}, dataset, function(response) {
                    $state.go('step3');
                });
            };
            
            $scope.step1=function(){
            	$state.go('step1');
            }
       
            $scope.presubmit=function()
            {
            	
            	bootbox.prompt({
            	    title: "Please provide your email address and we will send a link to download the report (e.g: juandelacruz@deped.gov.ph)",
            	    inputType: 'email',
            	    callback: function (result) {
            	    	
            	    	if(!isValidEmailAddress(result))
            	    		return false;
//            	    	
            	        var sendTo=[];
            	        sendTo.push(result);
            	        var serArr=$("#exportForm").serializeArray();
            	        
            	        
            	        var obj=JSON.parse(serArr[0].value);
            	        obj.sendTo=sendTo;
            	        serArr[0].value=JSON.stringify(obj);
            	        
            	        $.post($("#exportForm").attr('action'),serArr);
            	        
            	    
            	    	
            	    }
            	});
            }
            
            function isValidEmailAddress(emailAddress) {
                var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
                return pattern.test(emailAddress);
            };
            
            function call()
            {
            	$scope.datasetJson1="hoho";
            }
            
        }
    ]
);