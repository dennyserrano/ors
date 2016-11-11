var casper = require('casper').create();

casper.start('about:blank', function() {

    obj = new Object();
    obj.param1  = "value1";
    obj.param2  = "value2";  

    this.echo(casper.evaluate(function(myObject ) {
        return JSON.stringify(myObject);
    }, obj));
});

casper.run(function() {
    this.exit();
});
