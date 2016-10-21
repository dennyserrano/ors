var casper=require('casper').create({
	verbose:true,
	logLevel:'debug'
});


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


var checkboxName='#chk8';


var step1="casper.start(URL_BASE+'user/datasets',function(){" +
		"this.evaluate(function(){" +
		"$('"+checkboxName+"').click();"+
		"});"+
		"});";

var step1WaitForSelector="casper.waitForSelector('h4.list-group-item-heading',function(){" +
						"this.echo('list group shown');" +
							"this.evaluate(function(){" +
								"$('.btn-primary').click();" +
							"});" +
						"},10000);";

var step2="casper.waitForUrl(URL_BASE+'user/datasets#/2',function(){" +
		  "});";


var step2WaitSelector="casper.waitForSelector('thead',function(){" +
							  "this.evaluate(function(){" +
							  		"$('#nextBtn').click();" +
							  "});" +
					  "});";

var step3="casper.waitForUrl(URL_BASE+'user/datasets#/3',function(){" +
		  "});";

var step3WaitSelector="casper.waitForSelector('.form-group',function(){" +
							"this.echo('list form group shown');" +
							"this.evaluate(function(){" +
								"$('.btn-primary').click();" +
							"});" +
					  "},20000);";

var step4="casper.waitForUrl(URL_BASE+'user/datasets#/4',function(){" +
		"});";


var run="casper.run();";

var casperString=step1+step1WaitForSelector+step2+step2WaitSelector+step3+step3WaitSelector+step4+run;

var f=new Function('test',casperString);
f();


//casperStart(casper);

function casperStart(casper,next)
{
	
	console.log("Starting.....");
	
	casper.start(URL_BASE+"user/datasets",function(){
		
		
		this.evaluate(function(){
			$("#chk8").click();
			
		});

		
		
	});

	casper.waitForSelector("h4.list-group-item-heading",function(){
		this.echo("list group shown");
		this.evaluate(function(){
			
			$(".btn-primary").click();
			
		});
	});

	casper.waitForUrl(URL_BASE+"user/datasets#/2",function(){
		
	});

	casper.waitForSelector("thead",function(){
		this.evaluate(function(){
			$("#nextBtn").click();
		});
	})

	casper.waitForUrl(URL_BASE+"user/datasets#/3",function(){
		
	});

	casper.waitForSelector(".form-group",function(){
		this.echo("list form group shown");
		this.evaluate(function(){
			
			$(".btn-primary").click();
			
		});
	});

	casper.waitForUrl(URL_BASE+"user/datasets#/4",function(){
		
	});

	casper.waitForSelector("gggg",function(){
		
		
		
	},function(){
		
		if(next)
		{
			console.log("next!");
		}	
		
	},5000);

	
	

	casper.run();
}