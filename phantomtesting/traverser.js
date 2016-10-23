var casper=require('casper').create({
	verbose:true,
	logLevel:'debug'
});

//var casper2=require('casper').create();

var URL_BASE="http://localhost:8080/";

var li=function(resource,C){
	
	
//	console.log(resource.url.indexOf('preview')!=-1);
	if(resource.url.indexOf('preview')!=-1)
	{
		this.echo("REQUESTS:"+resource.url);
	};
	
};

casper.on("resource.requested", li);
casper.on("resource.received",function(resource){
//	if(JSON.stringify(obj).contains('Internal Server Error'))
//		{
//		this.echo("goccha!");
//		}
	
	if(resource.url.indexOf('preview')!=-1)
	{
		this.echo(resource.statusText);
	}
});
//casper.options.onResourceReceived=function(obj){
//	this.echo("dataset:"+JSON.stringify(obj));
//};

casper.on('remote.message', function(message) {
    this.echo("REMOTE MESSAGE: "+message);
});

var html=[];

casper.start(URL_BASE+"user/datasets", function() {
    html=this.evaluate(function() {
    	var p=[];
    	$(":checkbox").each(function(index,obj){
    		p.push(obj.id);
    	});
    	return p;
    });
    
    
    
    
    
    console.log(html);
});


casper.run();


//while(html.length==0)
//{
//	;
//}
//console.log('ohoy');
//var str=['chk8'];
//
//casper.start().eachThen(str,function(str){
//	
//	casper.thenOpenAndEvaluate(URL_BASE+"user/datasets",function(checkbox){
//		console.log("about to click:"+checkbox);
//		
//		$("#"+checkbox).click();
//	},str.data);
//	
//	
//	casper.waitForSelector("h4.list-group-item-heading",function(){
//		this.echo("list group shown");
//		this.evaluate(function(){
//			
//			$(".btn-primary").click();
//			
//		});
//	});
//	
//	
//		
//	casper.waitForUrl(URL_BASE+"user/datasets#/2",function(){
//		
//	});
//	
//	casper.waitForSelector("thead",function(){
//		this.evaluate(function(){
//			$("#nextBtn").click();
//		});
//	});
//	
//	casper.waitForUrl(URL_BASE+"user/datasets#/3",function(){
//		
//	});
//	
//	casper.waitForSelector(".form-group",function(){
//		this.echo("list form group shown");
//		this.evaluate(function(){
//			
//			$(".btn-primary").click();
//			
//		});
//	});
//	
//	casper.waitForUrl(URL_BASE+"user/datasets#/4",function(){
//		this.echo("open page 4!");
//	});
//	
//	casper.open(URL_BASE+"user/datasets",function(){
//		this.echo("open again page 1");
//	});
//	
//	
//
//}).run();


