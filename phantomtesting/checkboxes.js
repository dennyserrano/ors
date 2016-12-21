var casper=require('casper').create({
	logLevel:"debug"
});

casper.on('remote.message', function(message) {
    this.echo(message);
});

var URL_BASE="http://localhost:8080/";

var html=[];

casper.start(URL_BASE+"user/datasets", function() {
    html=this.evaluate(function() {
    	var p=[];
	    	$(":checkbox").each(function(index,obj){
	    		var i={};
	    		i.name=$(obj).parent().find('small').text();
	    		i.id=$(obj).attr('id');
	    		p.push(i);
	    		console.log(JSON.stringify(i)+",\n")
	    	});
    	});
    
//    console.log("result:"+JSON.stringify(html)+"\n");
    
    });

casper.run();

