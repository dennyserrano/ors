var targetHost='http://localhost:8080/user/datasets#/1';
var page = require('webpage').create();
page.open(targetHost, function(status) {
  if (status !== 'success') {
    console.log('Unable to access network');
  } else {
    
	var s=page.evaluate(function() {    
        
		var scope=angular.element($("#sidemenu-container")).scope();
        
        $("#chk8").attr('checked',true);
        
        
        $(".btn-primary").click();
        
        setTimeout(function(){
        	
        	
        	
        },10000);
        
        });

	page.render("step1.png");
	console.log(s);
	
  }
  phantom.exit();
});


